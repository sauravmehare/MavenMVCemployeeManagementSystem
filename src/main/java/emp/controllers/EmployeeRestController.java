package emp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import emp.empService.EmpService;
import emp.entity.Employee;

@Controller
public class EmployeeRestController {
	
	@Autowired
	private EmpService empService ;

//	@PostMapping(value="/employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
//	@ResponseBody
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		empService.saveEmployee(employee);
//		return employee;
//	}
	
//	@PostMapping(value="/employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
//	@ResponseBody
//	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
//		final HttpHeaders httpHeaders= new HttpHeaders();
//		empService.saveEmployee(employee);
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		return new ResponseEntity<Employee>(employee, httpHeaders, HttpStatus.OK);
//	}
	
	@PostMapping(value="/employee",produces =MediaType.APPLICATION_JSON_VALUE,headers="content-type:application/json")
	public @ResponseBody Employee saveEmployee() {
		Employee employee=new Employee();
		employee.setName("saurav");
		return employee;
	}


}
