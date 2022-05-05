package com.mobileapplicationdevelopment.dogvio.daycareDatabase;

public class DayCareModule {
    private int id;
    private String bedogname , bedogbreed,bedogage,bedogin,bedogout,bedogpackageno;
    private long started,finished;

    public DayCareModule(){

    }

    public DayCareModule(int id, String bedogname, String bedogbreed, String bedogage, String bedogin, String bedogout, String bedogpackageno, long started, long finished) {
        this.id = id;
        this.bedogname = bedogname;
        this.bedogbreed = bedogbreed;
        this.bedogage = bedogage;
        this.bedogin = bedogin;
        this.bedogout = bedogout;
        this.bedogpackageno = bedogpackageno;
        this.started = started;
        this.finished = finished;
    }

    public DayCareModule(String bedogname, String bedogbreed, String bedogage, String bedogin, String bedogout, String bedogpackageno, long started, long finished) {
        this.bedogname = bedogname;
        this.bedogbreed = bedogbreed;
        this.bedogage = bedogage;
        this.bedogin = bedogin;
        this.bedogout = bedogout;
        this.bedogpackageno = bedogpackageno;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBedogname() {
        return bedogname;
    }

    public void setBedogname(String bedogname) {
        this.bedogname = bedogname;
    }

    public String getBedogbreed() {
        return bedogbreed;
    }

    public void setBedogbreed(String bedogbreed) {
        this.bedogbreed = bedogbreed;
    }

    public String getBedogage() {
        return bedogage;
    }

    public void setBedogage(String bedogage) {
        this.bedogage = bedogage;
    }

    public String getBedogin() {
        return bedogin;
    }

    public void setBedogin(String bedogin) {
        this.bedogin = bedogin;
    }

    public String getBedogout() {
        return bedogout;
    }

    public void setBedogout(String bedogout) {
        this.bedogout = bedogout;
    }

    public String getBedogpackageno() {
        return bedogpackageno;
    }

    public void setBedogpackageno(String bedogpackageno) {
        this.bedogpackageno = bedogpackageno;
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
