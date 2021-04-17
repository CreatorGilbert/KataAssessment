package com.CreatorGilbert.KataAssessment;

public class BabySitter {
    private final int regularRate = 12, asleepRate = 8, lateRate = 16;
    private final int FIVEPM = 0, SIXPM = 1, TWELVEAM = 7, FOURAM = 11, THREEAM = 10;

    public BabySitter() {
    }

    private boolean startTimeVerification(int startTime) throws OutOfBoundsException {
        boolean isValid = (startTime <= THREEAM && startTime >= FIVEPM);
        if (!isValid)
            throw new OutOfBoundsException("The start time wasn't valid, needs to be 5PM-3AM.");
        return isValid;
    }

    private boolean endTimeVerification(int endTime) throws OutOfBoundsException {
        boolean isValid = (endTime <= FOURAM && endTime >= SIXPM);
        if (!isValid)
            throw new OutOfBoundsException("The end time wasn't valid, needs to be 6PM-4AM.");
        return isValid;
    }

    private boolean bedtimeVerification(int bedtime) {
        return (bedtime <= FOURAM && bedtime >= FIVEPM);
    }

    private boolean checkStartBeforeEnd(SetTimes times) throws OutOfBoundsException {
        boolean isValid = times.getStartTime() < times.getEndTime();
        if (!isValid)
            throw new OutOfBoundsException("Start time was not set before end time.");
        return isValid;
    }

    private int getRegularRateCost(SetTimes times) {
        int regularTotal = 0, endRegularRateTime = TWELVEAM;

        if (times.getEndTime() < TWELVEAM && times.getEndTime() <= times.getBedtime())
            endRegularRateTime = times.getEndTime();

        if (times.getBedtime() < TWELVEAM && times.getBedtime() < times.getEndTime())
            endRegularRateTime = times.getBedtime();

        if (endRegularRateTime > times.getStartTime())
            regularTotal = (endRegularRateTime - times.getStartTime()) * regularRate;

        return regularTotal;
    }

    private int getLateRateCost(SetTimes times) {
        int lateTotal = 0, startLateRateTime = TWELVEAM;

        if (times.getStartTime() > TWELVEAM)
            startLateRateTime = times.getStartTime();

        if (times.getEndTime() > startLateRateTime)
            lateTotal = (times.getEndTime() - startLateRateTime) * lateRate;

        return lateTotal;
    }

    private int getAsleepRateCost(SetTimes times) {
        int asleepTotal = 0, startAsleepRateTime = times.getBedtime(), EndAsleepRateTime = TWELVEAM;

        if (times.getStartTime() > times.getBedtime())
            startAsleepRateTime = times.getStartTime();

        if (times.getEndTime() < TWELVEAM)
            EndAsleepRateTime = times.getEndTime();

        if (EndAsleepRateTime > startAsleepRateTime)
            asleepTotal = (EndAsleepRateTime - startAsleepRateTime) * asleepRate;

        return asleepTotal;
    }

    public int getTotalCost(SetTimes times) throws OutOfBoundsException {
        int total = 0;
        if (startTimeVerification(times.getStartTime()) && endTimeVerification(times.getEndTime())
                && bedtimeVerification(times.getBedtime()) && checkStartBeforeEnd(times))
            total = getRegularRateCost(times) + getAsleepRateCost(times) + getLateRateCost(times);
        return total;
    }

}
