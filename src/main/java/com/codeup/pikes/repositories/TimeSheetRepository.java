package com.codeup.pikes.repositories;

import com.codeup.pikes.models.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    @Query(value = "SELECT time_out FROM time_sheets u WHERE u.user_id = ?1 && u.this_date LIKE ?2 LIMIT 1" , nativeQuery = true)
    TimeSheet timeSheetFind(Long id, Date currentDate);
}
