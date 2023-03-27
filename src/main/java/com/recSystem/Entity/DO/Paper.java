package com.recSystem.Entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Paper {
    private String title;
    @TableId(type = IdType.AUTO)
    private Integer paperId;
    private String authors;
    private String updateDate;
    private Boolean favorite;
    private String paperAbstract;
    private String comments;
    private String categories;
    private String url;

    public Paper(String title, int paperId, String authors, String updateDate, String paperAbstract, String comments, String categories, String url) {
        this.title = title;
        this.paperId = paperId;
        this.authors = authors;
        this.updateDate = updateDate;
        this.paperAbstract = paperAbstract;
        this.comments = comments;
        this.categories = categories;
        this.url = url;
    }
}
