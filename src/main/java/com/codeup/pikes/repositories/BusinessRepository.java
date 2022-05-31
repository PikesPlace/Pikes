package com.codeup.pikes.repositories;

import com.codeup.pikes.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findByName(String name);
}
