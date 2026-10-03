package com.tienanh.anhpt173.leave.repository;

import com.tienanh.anhpt173.leave.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployeeId(Long employeeId);

    List<LeaveRequest> findByStatus(String status);

    List<LeaveRequest> findByEmployeeIdAndStatus(
            Long employeeId,
            String status
    );
}
