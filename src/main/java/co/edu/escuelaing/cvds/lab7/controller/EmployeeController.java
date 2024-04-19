package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/retrieve")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/read")
    public String read(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "read";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "create";
    }

    @RequestMapping("/delete/{id}")
    public String getEmployee(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "delete";
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> exampleEmployees() {return  employeeService.getAllEmployees();}

    @PostMapping("/employees")
    @ResponseBody
    public List<Employee> exampleEmployees(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employeeService.getAllEmployees();
    }
}
