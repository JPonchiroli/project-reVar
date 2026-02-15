package com.joaop.ms.WebClient;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Services.Exception.AssetNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BrapiClient {

    private final WebClient brapiWebClient;

    public Mono<BrapiResponse> getQuote(String symbol) {

        return brapiWebClient
                .get()
                .uri("/quote/{symbol}", symbol)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        Mono.error(new AssetNotFoundException("Symbol Not Found: " + symbol))
                )
                .onStatus(HttpStatusCode::is5xxServerError, response ->
                        Mono.error(new RuntimeException("Error on BRAPI"))
                )
                .bodyToMono(BrapiResponse.class);

    }

}
