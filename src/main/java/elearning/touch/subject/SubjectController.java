package elearning.touch.subject;

import elearning.touch.employee.Employee;
import elearning.touch.employee.EmployeeRepository;
import elearning.touch.service.Service;
import elearning.touch.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ServiceRepository serviceRepository;

    // CRUD (Create, Retrieve, Update, Delete, List)

    @GetMapping("/list") // LIST
    List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping("create/")// CREATE SUBJECT
    Subject createSubject(
            @RequestBody Subject subject
    ) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/employees/{employeeId}") // ADD EMPLOYEE TO A SUBJECT
    Subject addEmployeeToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long employeeId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        subject.enrolledEmployees.add(employee);
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/service/{serviceId}") // ASSIGN SERVICE TO SUBJECT
    Subject assignServiceToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long serviceId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Service service = serviceRepository.findById(serviceId).get();
        subject.setService(service);
        return subjectRepository.save(subject);
    }
}
