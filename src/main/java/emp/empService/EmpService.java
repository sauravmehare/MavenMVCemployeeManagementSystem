package emp.empService;

import java.util.List;

import emp.entity.Employee;

public interface EmpService {
	void saveEmployee(Employee employee);
	void deleteEmployee(int employeeID);
	void updateEmployee(Employee employee);
	Employee getEmployee(int employeeID);
	List<Employee> getAllEmp();
}
