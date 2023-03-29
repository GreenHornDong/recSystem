package com.recSystem.Entity.DTO;

import lombok.Data;

@Data
public class PageDTO {
    private String query;
    private int maxLength;
    private int offset;
}
