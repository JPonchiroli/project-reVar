package com.joaop.ms.Services;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Dtos.IndividualDto;
import com.joaop.ms.Dtos.OperationRequestDto;
import com.joaop.ms.Dtos.OperationResponseDto;
import com.joaop.ms.Entities.Operation;
import com.joaop.ms.Feign.FeignIndividual;
import com.joaop.ms.Mappers.OperationMapper;
import com.joaop.ms.Repository.OperationRepository;
import com.joaop.ms.Services.Exception.OperationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;
    private final AssetService assetService;
    private final FeignIndividual feignIndividual;
    private final OperationMapper operationMapper;

    public OperationResponseDto insert(OperationRequestDto requestDto) {

        Operation operation = operationMapper.toOperation(requestDto);

        Optional<BrapiResponse.Asset> asset = Optional.ofNullable(assetService.getAsset(operation.getAssetSymbol()));

        IndividualDto individual = feignIndividual.getIndividual(requestDto.getIndividualId());

        if (asset.isPresent()) {

            operation.setShortName(asset.get().getShortName());
            operation.setLongName(asset.get().getLongName());
            operation.setAssetPrice(asset.get().getRegularMarketPrice());
            operation.setOperationPrice(operation.getAssetPrice() * operation.getAssetQuantity());
            operation.setOperationDate(LocalDate.now());

            operationRepository.save(operation);

        }

        return operationMapper.toOperationResponseDto(operation);

    }


    public OperationResponseDto getById(Long id) {

        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new OperationNotFoundException("Operation not found, Id: " + id));

        return operationMapper.toOperationResponseDto(operation);

    }

    public void delete(Long id) {

        operationRepository.delete(operationMapper.toOperation(getById(id)));

    }

}
