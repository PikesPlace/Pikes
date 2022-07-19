package com.codeup.pikes.repositories;

import com.codeup.pikes.models.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    @Query(value = "SELECT * FROM time_sheets WHERE time_sheets.user_id = ? && time_sheets.this_date LIKE CONCAT('%', ?, '%')", nativeQuery = true)
    TimeSheet timeSheetFind(Long id, Date currentDate);
}
