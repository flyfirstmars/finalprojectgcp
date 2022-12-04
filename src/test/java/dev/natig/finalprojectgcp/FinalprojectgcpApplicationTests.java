package dev.natig.finalprojectgcp;

import dev.natig.finalprojectgcp.model.domain.Purchase;
import dev.natig.finalprojectgcp.repository.PurchaseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class FinalprojectgcpApplicationTests {

    @MockBean
    private PurchaseRepository purchaseRepository;

    @Test
    void contextLoads() {
        Mockito.when(purchaseRepository.findAll()).thenReturn(List.of(new Purchase()));
    }

}
