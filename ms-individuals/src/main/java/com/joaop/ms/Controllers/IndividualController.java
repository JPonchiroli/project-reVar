package com.joaop.ms.Controllers;

import com.joaop.ms.Dtos.IndividualRequestDto;
import com.joaop.ms.Dtos.IndividualResponseDto;
import com.joaop.ms.Service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ms/individuals/")
public class IndividualController {

    @Autowired
    private IndividualService service;

    @PostMapping
    public ResponseEntity<IndividualResponseDto> insertIndividual(@RequestBody IndividualRequestDto requestDto) {

        IndividualResponseDto individualResponseDto = service.insert(requestDto);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(individualResponseDto);

    }

    @GetMapping("{individualId}")
    public ResponseEntity<IndividualResponseDto> getIndividual(@PathVariable Long individualId) {

        IndividualResponseDto individualResponseDto = service.getById(individualId);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(individualResponseDto);

    }

}
