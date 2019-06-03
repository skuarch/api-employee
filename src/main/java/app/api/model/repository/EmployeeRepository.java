package app.api.model.repository;

import app.api.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    @Query("from Employee e where e.id = :id and e.status = true")
    Employee existsEmployee(@Param("id") Long id);
    
}
