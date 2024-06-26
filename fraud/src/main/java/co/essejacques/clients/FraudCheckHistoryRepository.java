package co.essejacques.clients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
    Optional<FraudCheckHistory> findByCustomerId(Integer customerId);
}