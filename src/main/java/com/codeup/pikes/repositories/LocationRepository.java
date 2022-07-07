package com.codeup.pikes.repositories;

import com.codeup.pikes.models.Location;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByName(String name);

    @Query(value = "SELECT * FROM locations WHERE business_id LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Location> findLocations(Long id);

}
