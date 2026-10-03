package com.tienanh.anhpt173.leave.repository;

import com.tienanh.anhpt173.leave.entity.LeaveType;
import com.tienanh.anhpt173.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}
