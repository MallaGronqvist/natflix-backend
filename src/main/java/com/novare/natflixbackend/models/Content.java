package com.novare.natflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "content")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name="type_id")
    private Integer typeId;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "summary")
    private String summary;
    @Column(name = "logo_url")
    private String logoUrl;
    @Column(name = "banner_url")
    private String bannerUrl;
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @JsonIgnore
    @OneToOne(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="id")
    private Film film;

    @JsonIgnore
    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Series> seriesList = new ArrayList<>();

    public Content addSeries(Series series)
    {
        seriesList.add(series);
        series.setContent(this);
        return this;
    }
    public Content removeSeries(Series series)
    {
        seriesList.remove(series);
        series.setContent(null);
        return this;
    }
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

   public List<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Series> seriesList) {
 //       this.seriesList = seriesList;
        this.seriesList.addAll(seriesList);
    }

    public Content() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

}
