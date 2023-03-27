package com.recSystem.Entity.DTO;

public class StatusDTO {
    private static int code;
    private static String message;

    public StatusDTO(int code, String message) {
        StatusDTO.code = code;
        StatusDTO.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        StatusDTO.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        StatusDTO.message = message;
    }
}
