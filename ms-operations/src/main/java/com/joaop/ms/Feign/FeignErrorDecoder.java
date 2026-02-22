package com.joaop.ms.Feign;

import com.joaop.ms.Services.Exception.IndividualNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() == 404) {
            return new IndividualNotFoundException("Individual not found");
        }

        return new Default().decode(methodKey, response);
    }
}
