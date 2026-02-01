package com.joaop.ms.WebClient;

import com.joaop.ms.Dtos.BrapiResponse;
import lombok.RequiredArgsConstructor;
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
                .bodyToMono(BrapiResponse.class);

    }

}
