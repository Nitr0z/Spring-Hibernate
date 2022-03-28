package elearning.touch.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elearning.touch.subject.Subject;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "service")
    private Set<Subject> subjects;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return this.subjects;
    }

}
