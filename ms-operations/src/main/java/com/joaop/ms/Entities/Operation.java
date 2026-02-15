package com.joaop.ms.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "operation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long individualId;
    private String shortName;
    private String longName;
    private String assetSymbol;
    private Double assetPrice;
    private Integer assetQuantity;
    private Double operationPrice;
    private LocalDate operationDate;

}
