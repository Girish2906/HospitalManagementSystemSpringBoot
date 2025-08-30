package com.codingshuttle.youtube.hospitalManagement2.repository;

import com.codingshuttle.youtube.hospitalManagement2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}