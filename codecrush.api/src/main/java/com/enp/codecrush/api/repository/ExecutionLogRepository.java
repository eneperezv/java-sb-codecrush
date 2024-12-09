package com.enp.codecrush.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.enp.codecrush.api.model.ExecutionLog;

@Repository
public interface ExecutionLogRepository extends JpaRepository<ExecutionLog, Long> {
	
    List<ExecutionLog> findByUserId(String userId);

}
