package com.joaop.ms.Dtos;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OperationResponseDto {

    private Long individualId;
    private String shortName;
    private String longName;
    private String assetSymbol;
    private Double assetPrice;
    private Integer assetQuantity;
    private Double operationPrice;
    private LocalDate operationDate;

}
