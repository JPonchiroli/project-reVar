package com.joaop.ms.Services;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Dtos.OperationRequestDto;
import com.joaop.ms.Dtos.OperationResponseDto;
import com.joaop.ms.Entities.Operation;
import com.joaop.ms.Mappers.OperationMapper;
import com.joaop.ms.Repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private AssetService assetService;

    public OperationResponseDto insert(OperationRequestDto requestDto) {

        Operation operation = OperationMapper.INSTANCE.toOperation(requestDto);

        Optional<BrapiResponse.Asset> asset = Optional.ofNullable(assetService.getAsset(operation.getAssetSymbol()));

        if (asset.isPresent()) {

            operation.setShortName(asset.get().getShortName());
            operation.setLongName(asset.get().getLongName());
            operation.setAssetPrice(asset.get().getRegularMarketPrice());
            operation.setOperationPrice(operation.getAssetPrice() * operation.getAssetQuantity());
            operation.setOperationDate(LocalDate.now());

            operationRepository.save(operation);

        }

        return OperationMapper.INSTANCE.toOperationResponseDto(operation);

    }

}
