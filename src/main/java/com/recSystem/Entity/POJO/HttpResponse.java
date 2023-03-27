package com.recSystem.Entity.POJO;

import java.io.Serializable;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 标准响应，{code,data,message}
 *
 * @author Legolas_PRC
 * @date 2022/10/26 16:59
 **/
@Component
@Data
public class HttpResponse<Status, DataDTO> implements Serializable {

    private Status status;
    private DataDTO data;

    public HttpResponse(){}

    public HttpResponse(Status status, DataDTO data){
        this.status = status;
        this.data = data;
    }

    public DataDTO getData() {
        return data;
    }
}
