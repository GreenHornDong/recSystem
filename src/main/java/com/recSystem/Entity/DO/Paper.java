package com.recSystem.Entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Paper {
    @TableId(type = IdType.AUTO)
    private int paperId;
    @TableField("authors")
    private String authors;
    @TableField("title")
    private String title;
    @TableField("update_date")
    private String updateDate;
    @TableField("favorite")
    private Boolean favorite;
    @TableField("paper_abstract")
    private String paperAbstract;
    @TableField("comments")
    private String comments;
    @TableField("categories")
    private String categories;
    @TableField("subjects")
    private String subjects;
    @TableField("url")
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
    //public Paper(){}
}
