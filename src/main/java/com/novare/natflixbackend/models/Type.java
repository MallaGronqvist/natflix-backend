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
    private Integer id;
    private String type;

    @JsonIgnore
    @OneToMany(targetEntity = Content.class, cascade= CascadeType.ALL)
/*    @JoinTable(
            name = "content_type",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))

 */
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private List<Content> contentList;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "typeId", cascade = CascadeType.ALL)
    private List<Content> contentList;
*/
    public Type() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
