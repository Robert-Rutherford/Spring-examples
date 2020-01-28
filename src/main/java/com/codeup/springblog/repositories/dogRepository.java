package com.codeup.springblog.repositories;

import com.codeup.springblog.models.dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dogRepository extends JpaRepository<dog, Long> {

}
