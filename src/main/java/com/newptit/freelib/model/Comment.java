package com.newptit.freelib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    private String id;

    private String iduser;
    private String idresource;
    private String content;

    public Comment() {
    }

    public Comment(String id, String iduser, String idresource, String content) {
        this.id = id;
        this.iduser = iduser;
        this.idresource = idresource;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdresource() {
        return idresource;
    }

    public void setIdresource(String idresource) {
        this.idresource = idresource;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
