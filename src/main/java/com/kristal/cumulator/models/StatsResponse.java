package com.kristal.cumulator.models;



public class StatsResponse {
    private Integer last5MinutesSum;

    private Integer last10MinutesSum;

    private Integer last30MinutesSum;

    public StatsResponse() {
    }

    public Integer getLast5MinutesSum() {
        return last5MinutesSum;
    }

    public void setLast5MinutesSum(Integer last5MinutesSum) {
        this.last5MinutesSum = last5MinutesSum;
    }

    public Integer getLast10MinutesSum() {
        return last10MinutesSum;
    }

    public void setLast10MinutesSum(Integer last10MinutesSum) {
        this.last10MinutesSum = last10MinutesSum;
    }

    public Integer getLast30MinutesSum() {
        return last30MinutesSum;
    }

    public void setLast30MinutesSum(Integer last30MinutesSum) {
        this.last30MinutesSum = last30MinutesSum;
    }
}
