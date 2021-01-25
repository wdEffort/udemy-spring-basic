package com.udemy.springbasic.ex01di.sample07;

public class BaseBallTeam {

    private String manger;
    private String battingCoach;
    private String pitchingCoach;
    private String hitter;
    private String pitcher;

    public BaseBallTeam() {
    }

    public BaseBallTeam(String manger, String battingCoach, String pitchingCoach) {
        this.manger = manger;
        this.battingCoach = battingCoach;
        this.pitchingCoach = pitchingCoach;
    }

    public String getManger() {
        return manger;
    }

    public void setManger(String manger) {
        this.manger = manger;
    }

    public String getBattingCoach() {
        return battingCoach;
    }

    public void setBattingCoach(String battingCoach) {
        this.battingCoach = battingCoach;
    }

    public String getPitchingCoach() {
        return pitchingCoach;
    }

    public void setPitchingCoach(String pitchingCoach) {
        this.pitchingCoach = pitchingCoach;
    }

    public String getHitter() {
        return hitter;
    }

    public void setHitter(String hitter) {
        this.hitter = hitter;
    }

    public String getPitcher() {
        return pitcher;
    }

    public void setPitcher(String pitcher) {
        this.pitcher = pitcher;
    }
}
