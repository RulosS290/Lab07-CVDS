package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeesListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeesListRepository employeesListRepository;

    @Autowired
    public EmployeeService(EmployeesListRepository employeesListRepository) {
        this.employeesListRepository = employeesListRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeesListRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeesListRepository.findById(id).get(1);
    }

    public List<Employee> getAllEmployees() {
        return employeesListRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (employeesListRepository.findById(employee.getId()).size() == 0) {
            return employeesListRepository.save(employee);
        }

        return null;
    }

    public void deleteEmployee(int id) {
        employeesListRepository.deleteById(id);
    }
}
