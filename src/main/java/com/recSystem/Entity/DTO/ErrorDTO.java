package com.recSystem.Entity.DTO;

import lombok.Data;

@Data
public class ErrorDTO {
    private String key;
    private String value;

    public ErrorDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
