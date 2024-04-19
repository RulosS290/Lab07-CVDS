package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
public class Employee {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String First_name;
    @Column(name = "LAST_NAME")
    private String Last_name;
    @Column(name = "ROLE")
    private String Role;
    @Column(name = "SALARY")
    private Double Salary;

    public Employee(Integer id, String First_name, String Last_name, String Role, Double Salary) {
        this.id = id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Role = Role;
        this.Salary = Salary;
    }

    public Employee() {

    }
}

