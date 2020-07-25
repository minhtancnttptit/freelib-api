package com.newptit.freelib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    private String id;

    private String idpublisher;
    private String type;
    private String title;
    private String cover;
    private String category;
    private String description;
    private String link;

    public Resource() {
    }

    public Resource(String id, String idPublisher, String type, String title, String cover, String category, String description, String link) {
        this.id = id;
        this.idpublisher = idPublisher;
        this.type = type;
        this.title = title;
        this.cover = cover;
        this.category = category;
        this.description = description;
        this.link = link;
    }

    public String getIdpublisher() {
        return idpublisher;
    }

    public void setIdpublisher(String idPublisher) {
        this.idpublisher = idPublisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
