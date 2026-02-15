package com.joaop.ms.Services;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Services.Exception.AssetNotFoundException;
import com.joaop.ms.WebClient.BrapiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AssetService {

    private final BrapiClient brapiClient;

    public BrapiResponse.Asset getAsset(String symbol) {

        return brapiClient.getQuote(symbol)
                .flatMap(response ->
                        Mono.justOrEmpty(
                                response.getResults().stream().findFirst()
                        )
                )
                .switchIfEmpty(Mono.error(
                        new AssetNotFoundException("Symbol not found: " +symbol)
                ))
                .block();

    }


}
