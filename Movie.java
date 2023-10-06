package main;

public class Movie {
    private  String id;
    private String movieName;
    private String directorName;
    private String actRole;
    private String detail;
    private String time;

    public Movie() {
    }

    public Movie(String movieName, String directorName, String actRole, String detail, String time) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.actRole = actRole;
        this.detail = detail;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getActRole() {
        return actRole;
    }

    public void setActRole(String actRole) {
        this.actRole = actRole;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
