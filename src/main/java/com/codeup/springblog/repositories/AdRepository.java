package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByTitle(String title);
}
