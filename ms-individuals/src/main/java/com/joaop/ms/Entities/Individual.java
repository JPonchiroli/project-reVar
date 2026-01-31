package com.joaop.ms.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "individuals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long individualId;
    private String cpf;
    private String fullName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private String uf;
    private String birthPlace;
}
