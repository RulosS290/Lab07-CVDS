package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "read";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "create";
    }

    @GetMapping("/delete/{id}")
    public String getEmployee(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/retrieve/read";
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
    @GetMapping("/update/{id}")
    public String getEmployeeForUpdate(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Integer id, @RequestBody Map<String, String> updateData) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            return "redirect:/error";
        }


        if (updateData.containsKey("first_name")) {
            employee.setFirst_name(updateData.get("first_name"));
        }
        if (updateData.containsKey("last_name")) {
            employee.setLast_name(updateData.get("last_name"));
        }


        employeeService.updateEmployee(employee);

        return "redirect:/retrieve/read";
    }
}
