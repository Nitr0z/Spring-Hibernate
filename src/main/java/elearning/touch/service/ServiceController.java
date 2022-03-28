package elearning.touch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/list") //LIST
    List<Service> getServices() {
        return serviceRepository.findAll();
    }

    @PostMapping
    Service createService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }
}
