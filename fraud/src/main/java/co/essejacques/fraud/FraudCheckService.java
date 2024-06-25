package co.essejacques.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public Boolean isFraudster(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder().customerId(customerId).isFraudster(false).createAt(LocalDateTime.now()).build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
