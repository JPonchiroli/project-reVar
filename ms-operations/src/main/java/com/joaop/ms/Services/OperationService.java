package com.joaop.ms.Services;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Dtos.IndividualDto;
import com.joaop.ms.Dtos.OperationRequestDto;
import com.joaop.ms.Dtos.OperationResponseDto;
import com.joaop.ms.Entities.Operation;
import com.joaop.ms.Feign.FeignIndividual;
import com.joaop.ms.Mappers.OperationMapper;
import com.joaop.ms.Repository.OperationRepository;
import com.joaop.ms.Services.Exception.AssetNotFoundException;
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

        feignIndividual.getIndividual(requestDto.getIndividualId());

        BrapiResponse.Asset asset =
                Optional.ofNullable(assetService.getAsset(requestDto.getAssetSymbol()))
                        .orElseThrow(() ->
                                new AssetNotFoundException(
                                        "Asset not found: " + requestDto.getAssetSymbol()
                                )
                        );

        Operation operation = operationMapper.toOperation(requestDto);

        operation.setShortName(asset.getShortName());
        operation.setLongName(asset.getLongName());
        operation.setAssetPrice(asset.getRegularMarketPrice());
        operation.setOperationPrice(operation.getAssetPrice() * operation.getAssetQuantity());
        operation.setOperationDate(LocalDate.now());

        operationRepository.save(operation);

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
