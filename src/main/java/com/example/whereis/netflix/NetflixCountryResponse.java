package com.example.whereis.netflix;

import java.util.List;

public class NetflixCountryResponse {
    private Result[] results;

    public NetflixCountryResponse() {}
    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }
}

class Result {
    private String title;
    private String clist;
    private String img;
    private String imdbrating;
    private String year;
    private String poster;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImdbrating() {
        return imdbrating;
    }

    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public Result() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClist() {
        return clist;
    }

    public void setClist(String clist) {
        this.clist = clist;
    }

    public Result(String title, String clist, String img, String imdbrating, String year, String poster) {
        this.title = title;
        this.clist = clist;
        this.img = img;
        this.imdbrating = imdbrating;
        this.year = year;
        this.poster = poster;
    }
}

class Netflix {
    String title;
    List<String> countries;
    String apiCallsRemaining;
    String img;
    String imdbrating;
    String year;
    String poster;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImdbrating() {
        return imdbrating;
    }

    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void setApiCallsRemaining(String apiCallsRemaining) {
        this.apiCallsRemaining = apiCallsRemaining;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCountries() {
        return countries;
    }

    public String getApiCallsRemaining() {
        return apiCallsRemaining;
    }

    public Netflix() { }


    public Netflix(String title, List<String> countries, String apiCallsRemaining, String img, String imdbrating, String year, String poster) {
        this.title = title;
        this.countries = countries;
        this.apiCallsRemaining = apiCallsRemaining;
        this.img = img;
        this.imdbrating = imdbrating;
        this.year = year;
        this.poster = poster;
    }
}
