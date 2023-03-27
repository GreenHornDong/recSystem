package com.recSystem.Entity.DTO;

import java.util.List;

public class PaperDTO {
    private String title;
    private int paper_id;
    private List<AuthorDTO> authorDTOList;
    private String update_date;
    private Boolean favorite;
    private String paperAbstract;//前端需要改名字
    private String comments;
    private String categories;
    private String url;

    public List<AuthorDTO> getAuthorDTOList() {
        return authorDTOList;
    }

    public void setAuthorDTOList(List<AuthorDTO> authorDTOList) {
        this.authorDTOList = authorDTOList;
    }

    public PaperDTO(String title, int paperId, List<AuthorDTO> authorDTOList, String updateDate, String paperAbstract, String comments, String categories, String url) {
        this.title = title;
        this.paper_id = paperId;
        this.authorDTOList = authorDTOList;
        this.update_date = updateDate;
        this.paperAbstract = paperAbstract;
        this.comments = comments;
        this.categories = categories;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
