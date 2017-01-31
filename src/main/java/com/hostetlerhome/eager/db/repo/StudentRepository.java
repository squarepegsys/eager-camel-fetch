package com.hostetlerhome.eager.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mikeh on 1/10/17.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
