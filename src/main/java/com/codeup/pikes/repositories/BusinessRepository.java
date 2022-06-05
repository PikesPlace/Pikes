package com.codeup.pikes.repositories;

import com.codeup.pikes.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findByName(String name);

    @Query(value = "SELECT * FROM businesses ORDER BY name ASC", nativeQuery = true)
    List<Business> getBusinessesAlphabetical();

    @Query(value = "SELECT DISTINCT t.id, t.name FROM businesses t WHERE t.name LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Business> searchBusinesses(String search);

}
