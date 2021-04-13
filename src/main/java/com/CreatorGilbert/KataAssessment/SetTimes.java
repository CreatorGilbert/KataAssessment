package com.CreatorGilbert.KataAssessment;

class SetTimes {
    private int startTime, endTime, bedtime;

    SetTimes() {
        this.startTime = 0;
        this.endTime = 0;
        this.bedtime = 0;
    }

    public void setStartTime(int initalTime) {
        this.startTime = initalTime;
    }

    public void setEndTime(int finshedTime) {
        this.endTime = finshedTime;
    }

    public void setBedtime(int sleepTime) {
        this.bedtime = sleepTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getBedtime() {
        return bedtime;
    }

}
