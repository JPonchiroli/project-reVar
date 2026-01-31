package com.joaop.ms.Service;

import com.joaop.ms.Dtos.IndividualRequestDto;
import com.joaop.ms.Dtos.IndividualResponseDto;
import com.joaop.ms.Entities.Individual;
import com.joaop.ms.Mappers.IndividualMapper;
import com.joaop.ms.Repositories.IndividualRepository;
import com.joaop.ms.Service.Exceptions.IndividualNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

    public IndividualResponseDto insert(IndividualRequestDto requestDto) {

        Individual individual = IndividualMapper.INSTANCE.toIndividual(requestDto);

        individualRepository.save(individual);

         return IndividualMapper.INSTANCE.toIndividualResponseDto(individual);

    }

    public IndividualResponseDto getById(Long id) {

        Individual individual = individualRepository.findById(id)
                .orElseThrow(() -> new IndividualNotFoundException("Individual not found, Id: " + id));

        return IndividualMapper.INSTANCE.toIndividualResponseDto(individual);

    }

    public void delete(Long id) {

        individualRepository.delete(IndividualMapper.INSTANCE.toIndividual(getById(id)));

    }

}
