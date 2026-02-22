package com.joaop.ms.Mappers;

import com.joaop.ms.Dtos.OperationRequestDto;
import com.joaop.ms.Dtos.OperationResponseDto;
import com.joaop.ms.Entities.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper {

    OperationRequestDto toOperationRequestDto(Operation operation);

    OperationResponseDto toOperationResponseDto(Operation operation);

    Operation toOperation(OperationRequestDto requestDto);

    Operation toOperation(OperationResponseDto responseDto);

}
