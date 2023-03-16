package Employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Employee.dao.EmloyeeDao;
import Employee.dto.Employee;

@Controller
public class EmployeeController 
{
	@Autowired
	Employee employee;
	
	@Autowired
	EmloyeeDao dao;
	
	@GetMapping("Load")
	public ModelAndView LoadEmployee()
	{
		ModelAndView andView=new ModelAndView("Signup.jsp");
		andView.addObject("emp",employee);//Like setAttribute
		return andView;
	}

	
	 @PostMapping("signup")
		public ModelAndView saveEmployee(@ModelAttribute Employee emp)
		{
			dao.saveEmployee(emp);
			ModelAndView andView=new ModelAndView("Login.jsp");
			andView.addObject("msg","Account Created Successfullly");
			return andView;
		}
	
	@PostMapping("login")
	public ModelAndView login(@RequestParam String email,@RequestParam String pwd)
	{
//		ModelAndView andView=new ModelAndView("result.jsp");
//		andView.addObject("email",email);
//		andView.addObject("password",pwd);
//		return andView;
		ModelAndView andView=new ModelAndView("result.jsp");
	   Employee employee=dao.login(email);
	   if(employee==null)
	   {
		   andView.setViewName("Login.jsp");
		   andView.addObject("msg","Invalid Email");
	   }
	   else
	   {
		   if(pwd.equals(employee.getPassword()))
		   {
			   andView.setViewName("result.jsp");
			   andView.addObject("list",dao.fetchAll());
			   andView.addObject("msg","Logged in Successfully");
		   } 
		   else
		   {
			   andView.setViewName("Login.jsp");
			   andView.addObject("msg","Invalid Password");
		   }
	   }
	return andView;
	 }
	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam int id)
	{
		dao.delete(id);
		ModelAndView andView=new ModelAndView("result.jsp");
		 andView.addObject("list",dao.fetchAll());
		  andView.addObject("msg","Deleted Successfully");
		  return andView;	
	}
	
	@GetMapping("edit")
	public ModelAndView LoadEmployee(@RequestParam int id)
	{
		
		ModelAndView andView=new ModelAndView("Edit.jsp");
		andView.addObject("emp",dao.find(id));//Like setAttribute
		return andView;
	}
	@PostMapping("update")
	public ModelAndView update(@ModelAttribute Employee emp)
	{
		dao.update(emp);
		ModelAndView andView=new ModelAndView("result.jsp");
		   andView.addObject("list",dao.fetchAll());
		andView.addObject("msg","Updated Successfully");
		return andView;
		
	}
}
