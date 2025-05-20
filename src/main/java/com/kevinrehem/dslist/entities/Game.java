package com.kevinrehem.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;
@Entity //classifica classe como entidade a ser representada no banco
@Table(name = "tb_game")//da nome à tabela que será criada para representar entidade no banco
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//1

    @Column//usei essas anotations para contornar problema de ordem das colunas
    private String title;//2

    @Column
    private Double score;//3

    @Column(name = "game_year")
    private Integer year;//4

    @Column
    private String genre;//5

    @Column
    private String platforms;//6

    @Column
    private String imgUrl;//7

    @Column(columnDefinition = "TEXT") //força um tipo de dado no banco
    private String shortDescription;//8

    @Column(columnDefinition = "TEXT")
    private String longDescription;//9

    public Game(){}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return Objects.equals(getId(), game.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
