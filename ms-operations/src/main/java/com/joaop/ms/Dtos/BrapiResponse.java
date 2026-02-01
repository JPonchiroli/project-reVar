package com.joaop.ms.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrapiResponse {

    private List<Asset> results;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Asset {

        private String symbol;
        private String shortName;
        private String longName;
        private Double regularMarketPrice;
        private Double regularMarketChange;
        private Double regularMarketChangePercent;
        private Long regularMarketVolume;
        private Long marketCap;

    }

}
