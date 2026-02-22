package com.joaop.ms.Services;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Feign.FeignBrapi;
import com.joaop.ms.Services.Exception.AssetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final FeignBrapi feignBrapi;

    public BrapiResponse.Asset getAsset(String symbol) {

        BrapiResponse response = feignBrapi.getQuote(symbol);

        return Optional.ofNullable(response)
                .map(BrapiResponse::getResults)
                .filter(list -> !list.isEmpty())
                .map(list -> list.get(0))
                .orElseThrow(() -> new AssetNotFoundException("Asset not found"));
    }


}
