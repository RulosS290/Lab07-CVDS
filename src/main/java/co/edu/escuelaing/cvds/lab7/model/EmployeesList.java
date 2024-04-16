package co.edu.escuelaing.cvds.lab7.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeesList {
    private Integer id;
    private String first_Name;
    private String last_Name;

    public EmployeesList(Integer id, String first_Name, String last_Name) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

}

