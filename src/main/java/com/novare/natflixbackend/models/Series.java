package com.novare.natflixbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity (name = "details_series")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content_id")
    private Integer contentId;
    @Column(name = "season_number")
    private Integer seasonNumber;
    @Column(name = "episode_number")
    private Integer episodeNumber;
    private String title;
    private String summary;
    @Column(name= "thumbnail_url")
    private String thumbnailUrl;
    @Column(name = "video_code")
    private String videoCode;
/*
    @ManyToOne
    @JoinColumn(name = "series_list")
    private Content content;
*/
    public Series() {
    }
/*
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
*/
    public Series(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }
}
