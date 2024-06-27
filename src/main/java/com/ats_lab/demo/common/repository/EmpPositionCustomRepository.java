package com.ats_lab.demo.common.repository;

import com.ats_lab.demo.common.entity.custommodel.EmpPositionCustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpPositionCustomRepository extends JpaRepository<EmpPositionCustomEntity, Integer> {

    @Query(value = """
            select
            	e.emp_id,
            	e.emp_code,
            	e.first_name,
            	e.last_name,
            	p.position_name,
            	p.position_type_name
            from
            	"ATS-LAB".employees e
            join "ATS-LAB".positions p on
            	e.position_id = p.position_id
            where
            	e.emp_code = CAST(:emp_code AS varchar);
            """,nativeQuery = true)
    EmpPositionCustomEntity findByEmpCode(@Param("emp_code") String empCode);
}
