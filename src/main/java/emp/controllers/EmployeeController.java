package emp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import emp.empService.EmpService;
import emp.empServiceImpl.EmpServiceImpl;
import emp.entity.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmpService empService ;

	@RequestMapping("/")
	public String employeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "employeeform3";
	}

	@RequestMapping(value="/saveData",method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/employeelist";
	}


	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getEmployeesData(Model model) {
		List<Employee> employeeList = empService.getAllEmp();

		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}

	@RequestMapping(value = "/deleteEmployee/{empNo}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("empNo") int empNO) {

		empService.deleteEmployee(empNO);
		//List<Employee> employeeList = empService.getAllEmp();
		//ModelAndView mv=new ModelAndView("employeelist","employeeList",employeeList);
		//return mv;
		return "redirect:/employeelist";

	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam("employeeId") int employeeId) {
		Employee employee = empService.getEmployee(employeeId);
		//empService.deleteEmployee(employeeId);
		ModelAndView mv=new ModelAndView("employeeform2","employee",employee);
		return mv;
	}
	@RequestMapping(value = "/updated", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee employee) {

		empService.updateEmployee(employee);
		return "redirect:/employeelist";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchEmployee(@RequestParam("id") int employeeId,Model model){
		Employee employee = empService.getEmployee(employeeId);

		if(employee==null) {
			return "redirect:/";
		}
		//return "redirect:/updateEmployee?employeeId=ide";
		else {
			model.addAttribute("employee", employee);
			return "employeeform2";
		}
	}

}
