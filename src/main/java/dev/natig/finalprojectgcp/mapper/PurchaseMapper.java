package dev.natig.finalprojectgcp.mapper;


import dev.natig.finalprojectgcp.model.domain.Purchase;
import dev.natig.finalprojectgcp.model.dto.PurchaseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    Purchase toEntity(PurchaseDto dto);

    PurchaseDto toDto(Purchase purchase);
}
