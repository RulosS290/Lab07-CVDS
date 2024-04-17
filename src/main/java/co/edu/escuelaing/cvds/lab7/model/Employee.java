package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @NotNull
    private int Employee_id;
    @Column(name = "FIRST_NAME")
    @NotNull
    private String First_name;
    @Column(name = "LAST_NAME")
    @NotNull
    private String Last_name;
    @Column(name = "ROLE")
    @NotNull
    private String Role;
    @Column(name = "SALARY")
    @NotNull
    private Double Salary;

    public Employee(int Employee_id, String First_name, String Last_name, String Role, Double Salary) {
        this.Employee_id = Employee_id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Role = Role;
        this.Salary = Salary;
    }

    public Employee() {

    }
}

