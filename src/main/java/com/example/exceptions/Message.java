package com.example.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
    private String message;
}
