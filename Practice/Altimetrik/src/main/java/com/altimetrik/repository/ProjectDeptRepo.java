package com.altimetrik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Department;
import com.altimetrik.model.ProjectDept;

@Repository
public interface ProjectDeptRepo extends JpaRepository<ProjectDept,Integer>{

	@Query("select p from ProjectDept p where p.projId=:projId and p.dept =:dept")
	ProjectDept getPrjtDept(@Param("projId") String projId,@Param("dept")Department dept);
}
