package com.recSystem.Entity.DO;

import lombok.Data;

@Data
public class UserToPaper {
    private int userId;
    private int paperId;

    public UserToPaper(int userId, int paperId){
        this.userId = userId;
        this.paperId = paperId;
    }

}
