package com.joaop.ms.Controllers;

import com.joaop.ms.Dtos.OperationRequestDto;
import com.joaop.ms.Dtos.OperationResponseDto;
import com.joaop.ms.Services.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
