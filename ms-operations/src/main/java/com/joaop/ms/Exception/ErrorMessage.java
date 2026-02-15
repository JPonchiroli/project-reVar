package com.joaop.ms.Exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorMessage {

    private String path;
    private String method;
    private int status;
    private String error;
    private String message;

}
