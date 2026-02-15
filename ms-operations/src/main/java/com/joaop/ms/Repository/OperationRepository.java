package com.joaop.ms.Repository;

import com.joaop.ms.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
