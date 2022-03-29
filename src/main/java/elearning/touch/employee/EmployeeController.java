package elearning.touch.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/list") //LIST
    List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

}