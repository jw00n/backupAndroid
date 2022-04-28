package com.example.movieapp;

public class MovieVO {

    private int poster;
    private String rank;
    private String movieNm;
    private String openDt;
    private String audiAcc;
    private String description;



    public MovieVO(int poster, String rank, String movieNm, String openDt, String audiAcc, String description) {
        this.poster = poster;
        this.rank = rank;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiAcc = audiAcc;
        this.description = description;
    }

    public int getPoster() {
        return poster;
    }

    public String getRank() {
        return rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MovieVO{" +
                "poster=" + poster +
                ", rank='" + rank + '\'' +
                ", movieNm='" + movieNm + '\'' +
                ", openDt='" + openDt + '\'' +
                ", audiAcc='" + audiAcc + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


