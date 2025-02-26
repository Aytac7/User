package com.example.user.exception.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter

public class ErrorResponse {
    String code;
    String message;
}