package com.recSystem.Entity.DTO;

import lombok.Data;

import java.util.List;

@Data
public class DataDTO {
    private PaperDTO paperDTO;
    private String token;
    private String expireTime;
    private List<ErrorDTO> errorDTOS;
    public DataDTO(Object o, String token, String expireTime) {
        this.token = token;
        this.expireTime = expireTime;
    }
    public DataDTO(List<ErrorDTO> errorDTOS){
        this.errorDTOS = errorDTOS;
    }

    public DataDTO(String token){
        this.token = token;
    }


}
