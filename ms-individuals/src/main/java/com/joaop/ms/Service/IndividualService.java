package com.joaop.ms.Service;

import com.joaop.ms.Dtos.IndividualRequestDto;
import com.joaop.ms.Dtos.IndividualResponseDto;
import com.joaop.ms.Entities.Individual;
import com.joaop.ms.Mappers.IndividualMapper;
import com.joaop.ms.Repositories.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

    public IndividualResponseDto insert(IndividualRequestDto requestDto) {

        Individual individual = IndividualMapper.INSTANCE.toIndividual(requestDto);

        individualRepository.save(individual);

         return IndividualMapper.INSTANCE.toIndividualResponseDto(individual);

    }

}
