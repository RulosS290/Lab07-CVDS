package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.EmployeesList;
import co.edu.escuelaing.cvds.lab7.repository.ConfigurationRepository;
import co.edu.escuelaing.cvds.lab7.repository.EmployeesListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeesListRepository employeesListRepository;

    @Autowired
    public EmployeeService(EmployeesListRepository employeesListRepository) {
        this.employeesListRepository = employeesListRepository;
    }

    public EmployeesList addEmployee(EmployeesList employeesList) {
        return employeesListRepository.save(employeesList);
    }

    public EmployeesList getEmployee(Integer id) {
        return employeesListRepository.findById(id).get(1);
    }

    public List<EmployeesList> getAllEmployees() {
        return employeesListRepository.findAll();
    }

    public EmployeesList updateEmployee(EmployeesList employeesList) {
        if (employeesListRepository.findById(employeesList.getId()).size() == 0) {
            return employeesListRepository.save(employeesList);
        }

        return null;
    }

    public void deleteEmployee(Integer id) {
        employeesListRepository.deleteById(id);
    }
}
