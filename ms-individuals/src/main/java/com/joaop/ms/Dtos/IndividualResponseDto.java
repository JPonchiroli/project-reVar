package com.joaop.ms.Dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IndividualResponseDto {

    private Long individualId;
    private String cpf;
    private String fullName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private String uf;
    private String birthPlace;

}
