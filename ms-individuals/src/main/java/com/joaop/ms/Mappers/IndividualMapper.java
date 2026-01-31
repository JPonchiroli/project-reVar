package com.joaop.ms.Mappers;

import com.joaop.ms.Dtos.IndividualRequestDto;
import com.joaop.ms.Dtos.IndividualResponseDto;
import com.joaop.ms.Entities.Individual;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IndividualMapper {

    IndividualMapper INSTANCE = Mappers.getMapper(IndividualMapper.class);

    IndividualRequestDto toIndividualRequestDto(Individual individual);

    IndividualResponseDto toIndividualResponseDto(Individual individual);

    Individual toIndividual(IndividualRequestDto requestDto);

}
