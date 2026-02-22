package com.joaop.ms.Feign;

import com.joaop.ms.Config.FeignConfig;
import com.joaop.ms.Dtos.IndividualDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msIndividuals", url = "http://localhost:8080/ms", configuration = FeignConfig.class)
public interface FeignIndividual {

    @GetMapping("/individuals/{individualId}")
    IndividualDto getIndividual(@PathVariable Long individualId);

}
