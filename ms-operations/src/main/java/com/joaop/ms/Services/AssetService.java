package com.joaop.ms.Services;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.WebClient.BrapiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final BrapiClient brapiClient;

    public BrapiResponse.Asset getAsset(String symbol) {

        return brapiClient.getQuote(symbol)
                .map(response -> response.getResults().get(0))
                .block();

    }


}
