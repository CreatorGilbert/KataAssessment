package com.CreatorGilbert.KataAssessment;

class SetTimes {
    private int startTime, endTime, bedtime;

    SetTimes() {
        this.startTime = 0;
        this.endTime = 0;
        this.bedtime = 0;
    }

    private boolean isGivenTimeValid(int time, boolean isPM) throws OutOfBoundsException {
        boolean isValid = false;
        if (isPM && time >= 5 && time <= 11) {
            isValid = true;
        } else if (!isPM && (time == 12 || time >= 1 && time <= 4)){
                isValid = true;
        }else {
            throw new OutOfBoundsException("The time wasn't valid. Time given was: " + time + (isPM ? " PM" : " AM"));
        }
        return isValid;
    }

    private int transformTime(int time, boolean isPM) throws OutOfBoundsException {
        int ans = 0;
        if (isGivenTimeValid(time, isPM)) {
            if (isPM) {
                ans = time - 5;
            } else {
                if (time == 12) {
                    ans = time - 5;
                } else {
                    ans = time + 7;
                }
            }
        }
        return ans;
    }

    public void setStartTime(int initalTime, boolean isPM) throws OutOfBoundsException {
        this.startTime = transformTime(initalTime, isPM);
    }

    public void setEndTime(int finshedTime, boolean isPM) throws OutOfBoundsException {
        this.endTime = transformTime(finshedTime, isPM);
    }

    public void setBedtime(int sleepTime, boolean isPM) throws OutOfBoundsException {
        this.bedtime = transformTime(sleepTime, isPM);
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
