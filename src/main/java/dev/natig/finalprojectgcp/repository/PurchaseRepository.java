package dev.natig.finalprojectgcp.repository;

import dev.natig.finalprojectgcp.model.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
