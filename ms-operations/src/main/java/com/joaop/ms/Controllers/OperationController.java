package com.joaop.ms.Controllers;

import com.joaop.ms.Dtos.OperationRequestDto;
import com.joaop.ms.Dtos.OperationResponseDto;
import com.joaop.ms.Services.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ms/operations/operation")
@RequiredArgsConstructor
public class OperationController {

    @Autowired
    private OperationService service;

    @PostMapping()
    public ResponseEntity<OperationResponseDto> postOperation(@RequestBody OperationRequestDto operationRequestDto) {

        OperationResponseDto operation = service.insert(operationRequestDto);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(operation);
    }

    @GetMapping("/{operationId}")
    public ResponseEntity<OperationResponseDto> getOperation(@PathVariable Long operationId) {

        OperationResponseDto operation = service.getById(operationId);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(operation);

    }

    @DeleteMapping("{individualId}")
    public ResponseEntity<OperationResponseDto> deleteIndividual(@PathVariable Long individualId) {

        service.delete(individualId);

        return ResponseEntity.noContent().build();

    }


}
