package dev.natig.finalprojectgcp.controller;

import dev.natig.finalprojectgcp.mapper.PurchaseMapper;
import dev.natig.finalprojectgcp.model.domain.Purchase;
import dev.natig.finalprojectgcp.model.dto.PurchaseDto;
import dev.natig.finalprojectgcp.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Validated
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper mapper;

    @GetMapping("/purchases")
    public List<PurchaseDto> getPosts() {
        return purchaseRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/purchases/{id}")
    public ResponseEntity<PurchaseDto> getPurchaseById(@PathVariable long id) {
        return purchaseRepository.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/purchases")
    public ResponseEntity<PurchaseDto> savePurchase(@RequestBody @Validated PurchaseDto purchaseDto) {
        return new ResponseEntity<>(mapper.toDto(purchaseRepository.save(mapper.toEntity(purchaseDto))), HttpStatus.CREATED);
    }

    @PutMapping("/purchases/{id}")
    public ResponseEntity<PurchaseDto> updatePurchas(@PathVariable long id, @RequestBody @Validated PurchaseDto purchaseDto) {
        return purchaseRepository.findById(id)
                .map(existsPurchase -> {
                    existsPurchase.setSeller(purchaseDto.getSeller());
                    existsPurchase.setDescription(purchaseDto.getDescription());
                    existsPurchase.setTitle(purchaseDto.getTitle());
                    existsPurchase.setFullText(purchaseDto.getFullText());
                    return ResponseEntity.ok(mapper.toDto(purchaseRepository.save(existsPurchase)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/purchases/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable Long id) {
        purchaseRepository.deleteById(id);
    }


}
