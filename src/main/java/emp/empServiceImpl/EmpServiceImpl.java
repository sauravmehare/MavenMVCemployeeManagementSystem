package emp.empServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emp.dao.EmployeeDAO;
import emp.daoImpl.EmployeeDAOImpl;
import emp.empService.EmpService;
import emp.entity.Employee;

@Service
public class EmpServiceImpl implements EmpService {
	
	private static int count=0;
	@Autowired
	EmployeeDAO employeeDao;
	
	public EmpServiceImpl() {
		System.out.println("EmpServiceImpl getting called");
	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		//employee.setEmployeeId(count++);
		employeeDao.saveEmployee(employee);
	}

	public void deleteEmployee(int employeeID) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employeeID);
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
	}

	public Employee getEmployee(int employeeID) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(employeeID);
	}

	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmp();
	}

}
