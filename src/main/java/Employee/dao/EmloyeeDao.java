package Employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import Employee.dto.Employee;


@Component
public class EmloyeeDao 
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveEmployee(Employee employee)
	{
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	 public Employee login(String email)
	 {
		List<Employee> list= manager.createQuery("select x from Employee x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty())//it is used in case of where the email is non primary key
		{
			return null;
		}
		else
		{
			return list.get(0);//data present inside the table
		}
	 }
	 
	 public List<Employee> fetchAll()
	 {
		 return manager.createQuery("select x from Employee x").getResultList();
	 }
	 public void delete(int id)
	 {
		 transaction.begin();
		 manager.remove(find(id));
		 transaction.commit();
	 }
	public Employee find(int id)
	{
		return manager.find(Employee.class, id);
	}
	public void update(Employee emp) 
	{
		manager.merge(emp);
		
	}

	
	   
}
