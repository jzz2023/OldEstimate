package com.estimate.pojo;

//等级评估
public class Egrade {
    private int eid;
    private String oldername;
    private String regno; //登记编号
    private String dailylife;
    private String psychosis; //精神状态评级
    private String sense; //感知评级
    private String involve; //社会参与评级
    private String enumber;

    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getOldername() {
        return oldername;
    }

    public void setOldername(String oldername) {
        this.oldername = oldername;
    }

    public String getDailylife() {
        return dailylife;
    }

    public void setDailylife(String dailylife) {
        this.dailylife = dailylife;
    }

    public String getPsychosis() {
        return psychosis;
    }

    public void setPsychosis(String psychosis) {
        this.psychosis = psychosis;
    }

    public String getSense() {
        return sense;
    }

    public void setSense(String sense) {
        this.sense = sense;
    }

    public String getInvolve() {
        return involve;
    }

    public void setInvolve(String involve) {
        this.involve = involve;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }
}
