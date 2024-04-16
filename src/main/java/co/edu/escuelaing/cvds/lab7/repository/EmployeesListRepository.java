package co.edu.escuelaing.cvds.lab7.repository;
import co.edu.escuelaing.cvds.lab7.model.EmployeesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesListRepository extends JpaRepository<EmployeesList, Integer> {
    public List<EmployeesList> findByIds(Integer id);

}