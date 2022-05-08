package com.mobileapplicationdevelopment.dogvio.HealthCareMealDB;

public class HealthCareMealModule {
    private int id;
    private String morningmeal, noonmeal, nigthmeal,daymeal;
    private long started,finished;



    public HealthCareMealModule() {
        this.id = id;
        this.morningmeal = morningmeal;
        this.noonmeal = noonmeal;
        this.nigthmeal = nigthmeal;
        this.daymeal = daymeal;
        this.started = started;
        this.finished = finished;
    }


    public HealthCareMealModule(String morningmeal, String noonmeal, String nigthmeal, String daymeal, long started, long finished) {
        this.morningmeal = morningmeal;
        this.noonmeal = noonmeal;
        this.nigthmeal = nigthmeal;
        this.daymeal = daymeal;
        this.started = started;
        this.finished = finished;
    }

    public HealthCareMealModule(int id, String morningmeal, String noonmeal, String nigthmeal, String daymeal, long started, long finished) {
        this.id = id;
        this.morningmeal = morningmeal;
        this.noonmeal = noonmeal;
        this.nigthmeal = nigthmeal;
        this.daymeal = daymeal;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMorningmeal() {
        return morningmeal;
    }

    public void setMorningmeal(String morningmeal) {
        this.morningmeal = morningmeal;
    }

    public String getNoonmeal() {
        return noonmeal;
    }

    public void setNoonmeal(String noonmeal) {
        this.noonmeal = noonmeal;
    }

    public String getNigthmeal() {
        return nigthmeal;
    }

    public void setNigthmeal(String nigthmeal) {
        this.nigthmeal = nigthmeal;
    }

    public String getDaymeal() {
        return daymeal;
    }

    public void setDaymeal(String daymeal) {
        this.daymeal = daymeal;
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
