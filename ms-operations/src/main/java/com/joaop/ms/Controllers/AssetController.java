package com.joaop.ms.Controllers;

import com.joaop.ms.Dtos.BrapiResponse;
import com.joaop.ms.Services.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ms/operations/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/{symbol}")
    public ResponseEntity<BrapiResponse.Asset> getAsset(@PathVariable String symbol) {

        BrapiResponse.Asset asset = assetService.getAsset(symbol);

        return ResponseEntity.ok(asset);

    }

}
