package com.novare.natflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "content_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "type_id")
    private List<Content> contentList;

    public Type() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Content> getContentList() {
        return contentList;
    }
}
