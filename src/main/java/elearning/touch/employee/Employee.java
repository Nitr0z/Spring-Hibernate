package elearning.touch.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import elearning.touch.subject.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String surname;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledEmployees")
    private Set<Subject> subjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

}
