package com.CreatorGilbert.KataAssessment;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BabySitterTest {
    private BabySitter testSitter;
    private SetTimes testTimes;
    private final int FIVEPM = 0, SIXPM = 1, NINEPM = 4, TWELVEAM = 7, FOURAM = 11, THREEAM = 10;

    @Before
    public void createUsedObjects() {
        testSitter = new BabySitter();
        testTimes = new SetTimes();
    }

    @Test
    public void shouldCheckStartTimeAtFivePMIsValid() {
        int startTime = FIVEPM;
        assertTrue(testSitter.startTimeVerification(startTime));
    }

    @Test
    public void shouldCheckStartTimeAtThreeAMIsValid() {
        int startTime = THREEAM;
        assertTrue(testSitter.startTimeVerification(startTime));
    }

    @Test
    public void shouldCheckStartTimeAtFourAMIsInvalid() {
        int startTime = FOURAM;
        assertFalse(testSitter.startTimeVerification(startTime));
    }

    @Test
    public void shouldCheckEndTimeAtFourAMIsValid() {
        int endTime = FOURAM;
        assertTrue(testSitter.endTimeVerification(endTime));
    }

    @Test
    public void shouldCheckEndTimeAtSixPMIsValid() {
        int endTime = SIXPM;
        assertTrue(testSitter.endTimeVerification(endTime));
    }

    @Test
    public void shouldCheckEndTimeAtFivePMIsInvalid() {
        int endTime = FIVEPM;
        assertFalse(testSitter.endTimeVerification(endTime));
    }

    @Test
    public void shouldCheckBedtimeEarliestStartAtFivePMIsValid() {
        int bedtime = FIVEPM;
        assertTrue(testSitter.bedtimeVerification(bedtime));
    }

    @Test
    public void shouldCheckBedtimeAtFourAMIsValid() {
        int bedtime = FOURAM;
        assertTrue(testSitter.bedtimeVerification(bedtime));
    }

    @Test
    public void shouldGetRegularRateMaxAmount() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(TWELVEAM);
        assertEquals(84, testSitter.getRegularRateCost(testTimes));
    }

    @Test
    public void shouldGetRegularWhenBothEndTimeBedtimeIsAfterTwevleAM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(THREEAM);
        assertEquals(84, testSitter.getRegularRateCost(testTimes));
    }

    @Test
    public void shouldGetRegularRateWhenBedtimeIsBeforeTwelveAM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(NINEPM);
        assertEquals(48, testSitter.getRegularRateCost(testTimes));
    }

    @Test
    public void shouldGetRegularRatWhenEndTimeIsBeforeBedTimeBeforeTwelveAM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(NINEPM);
        testTimes.setBedtime(TWELVEAM);
        assertEquals(48, testSitter.getRegularRateCost(testTimes));
    }

    @Test
    public void shouldGetRegularRateWhenBedTimeIsTheSameAsStartTime() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(NINEPM);
        testTimes.setBedtime(FIVEPM);
        assertEquals(0, testSitter.getRegularRateCost(testTimes));
    }

    @Test
    public void shouldGetRegularRateWhenBedtimeIsBeforeStartTime() {
        testTimes.setStartTime(SIXPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(FIVEPM);
        assertEquals(0, testSitter.getRegularRateCost(testTimes));
    }

    @Test
    public void shouldGetLateRateMaxAmount() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(NINEPM);
        assertEquals(64, testSitter.getLateRateCost(testTimes));
    }

    @Test
    public void shouldGetLateRateWhenStartTimeIsAfterTwelveAM() {
        testTimes.setStartTime(THREEAM);
        testTimes.setBedtime(SIXPM);
        testTimes.setEndTime(FOURAM);
        assertEquals(16, testSitter.getLateRateCost(testTimes));
    }

    @Test
    public void shouldGetLateRateWhenEndTimeIsEarlierThanLatestTime() {
        testTimes.setStartTime(NINEPM);
        testTimes.setBedtime(TWELVEAM);
        testTimes.setEndTime(THREEAM);
        assertEquals(48, testSitter.getLateRateCost(testTimes));
    }

    @Test
    public void shouldGetLateRateWhenEndTimeIsEarlierThanTwelvePM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setBedtime(SIXPM);
        testTimes.setEndTime(NINEPM);
        assertEquals(0, testSitter.getLateRateCost(testTimes));
    }

    @Test
    public void shouldGetAsleepRateFromFivePMToFourAMBedAtNinePM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(NINEPM);
        assertEquals(24, testSitter.getAsleepRateCost(testTimes));
    }

    @Test
    public void shouldGetAsleepRateWhenBedTimeIsTheSameAsStartTime() {
        testTimes.setStartTime(SIXPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(SIXPM);
        assertEquals(48, testSitter.getAsleepRateCost(testTimes));
    }

    @Test
    public void shouldGetAsleepRateWhenBedTimeIsTheEarlierThanStartTime() {
        testTimes.setStartTime(SIXPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(FIVEPM);
        assertEquals(48, testSitter.getAsleepRateCost(testTimes));
    }

    @Test
    public void shouldGetAsleepRateMaxAmount() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(FIVEPM);
        assertEquals(56, testSitter.getAsleepRateCost(testTimes));
    }

    @Test
    public void shouldGetAsleepRateWhenEndTimeIsEarlierThanTwelveAM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(NINEPM);
        testTimes.setBedtime(SIXPM);
        assertEquals(24, testSitter.getAsleepRateCost(testTimes));
    }

    @Test
    public void shouldGetAsleepRateWhenBedtimeIsAfterTwelveAM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(THREEAM);
        assertEquals(0, testSitter.getAsleepRateCost(testTimes));
    }

    @Test
    public void shouldGetTotalCostFivePMToFOURAMBedtimeAtNinePM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(FOURAM);
        testTimes.setBedtime(NINEPM);
        assertEquals(136, testSitter.getTotalCost(testTimes));
    }

    @Test
    public void shouldGetTotalCostFivePMToSixPM() {
        testTimes.setStartTime(FIVEPM);
        testTimes.setEndTime(SIXPM);
        testTimes.setBedtime(TWELVEAM);
        assertEquals(12, testSitter.getTotalCost(testTimes));
    }

}
