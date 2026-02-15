package com.joaop.ms.Dtos;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OperationRequestDto {

    private Long individualId;
    private String assetSymbol;
    private Integer assetQuantity;

}
