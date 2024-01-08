package co.essejacques.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public Boolean isFraudster(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder().customerId(customerId).isFraudster(false).createAt(LocalDateTime.now()).build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
