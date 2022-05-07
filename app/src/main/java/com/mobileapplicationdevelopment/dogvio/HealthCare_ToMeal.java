package com.mobileapplicationdevelopment.dogvio;

public class HealthCare_ToMeal {
    private int id;
    private String morning, noon, night, day;
    private long started, finished;

    public HealthCare_ToMeal(){

    }

    public HealthCare_ToMeal(int id, String morning, String noon, String night, String day, long started, long finished) {
        this.id = id;
        this.morning = morning;
        this.noon = noon;
        this.night = night;
        this.day = day;
        this.started = started;
        this.finished = finished;
    }

    public HealthCare_ToMeal(String morning, String noon, String night, String day, long started, long finished) {
        this.morning = morning;
        this.noon = noon;
        this.night = night;
        this.day = day;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
