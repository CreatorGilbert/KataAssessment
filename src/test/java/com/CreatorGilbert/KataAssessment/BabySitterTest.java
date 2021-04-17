package com.CreatorGilbert.KataAssessment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BabySitterTest {
    private BabySitter testSitter;
    private SetTimes testTimes;
    private final boolean PM = true, AM = false;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createUsedObjects() {
        testSitter = new BabySitter();
        testTimes = new SetTimes();
    }

    // @Test
    // public void shouldCheckExceptionForStartTimeAtFourAM() throws
    // OutOfBoundsException{
    // thrown.expect(OutOfBoundsException.class);
    // thrown.expectMessage("The start time wasn't valid, needs to be 5PM-3AM.");
    // int startTime = testTimes.transformTime(4, AM);
    // testSitter.startTimeVerification(startTime);
    // }

    // @Test
    // public void shouldCheckStartTimeAtFivePMIsValid() throws OutOfBoundsException
    // {
    // int startTime = testTimes.transformTime(5, PM);
    // assertTrue(testSitter.startTimeVerification(startTime));
    // }

    // @Test
    // public void shouldCheckStartTimeAtThreeAMIsValid() throws
    // OutOfBoundsException {
    // int startTime = testTimes.transformTime(3, AM);
    // assertTrue(testSitter.startTimeVerification(startTime));
    // }

    // @Test
    // public void shouldCheckExceptionForEndTimeAtFivePM() throws
    // OutOfBoundsException{
    // thrown.expect(OutOfBoundsException.class);
    // thrown.expectMessage("The end time wasn't valid, needs to be 6PM-4AM.");
    // int endTime = testTimes.transformTime(5, PM);
    // testSitter.endTimeVerification(endTime);
    // }

    // @Test
    // public void shouldCheckEndTimeAtFourAMIsValid() throws OutOfBoundsException {
    // int endTime = testTimes.transformTime(4, AM);
    // assertTrue(testSitter.endTimeVerification(endTime));
    // }

    // @Test
    // public void shouldCheckEndTimeAtSixPMIsValid() throws OutOfBoundsException {
    // int endTime = testTimes.transformTime(6, PM);
    // assertTrue(testSitter.endTimeVerification(endTime));
    // }

    // @Test
    // public void shouldCheckBedtimeAtFourAMIsValid() throws OutOfBoundsException {
    // int bedtime = testTimes.transformTime(4, false);
    // assertTrue(testSitter.bedtimeVerification(bedtime));
    // }

    // @Test
    // public void shouldGetRegularRateMaxAmount() throws OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(12, AM);
    // assertEquals(84, testSitter.getRegularRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetRegularWhenBothEndTimeBedtimeIsAfterTwevleAM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(3, AM);
    // assertEquals(84, testSitter.getRegularRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetRegularRateWhenBedtimeIsBeforeTwelveAM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(9, PM);
    // assertEquals(48, testSitter.getRegularRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetRegularRatWhenEndTimeIsBeforeBedTimeBeforeTwelveAM()
    // throws OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(9, PM);
    // testTimes.setBedtime(12, AM);
    // assertEquals(48, testSitter.getRegularRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetRegularRateWhenBedTimeIsTheSameAsStartTime() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(9, PM);
    // testTimes.setBedtime(5, PM);
    // assertEquals(0, testSitter.getRegularRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetRegularRateWhenBedtimeIsBeforeStartTime() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(5, PM);
    // assertEquals(0, testSitter.getRegularRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetLateRateMaxAmount() throws OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(9, PM);
    // assertEquals(64, testSitter.getLateRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetLateRateWhenStartTimeIsAfterTwelveAM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(3, AM);
    // testTimes.setBedtime(6, PM);
    // testTimes.setEndTime(4, AM);
    // assertEquals(16, testSitter.getLateRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetLateRateWhenEndTimeIsEarlierThanLatestTime() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(9, PM);
    // testTimes.setBedtime(12, AM);
    // testTimes.setEndTime(3, AM);
    // assertEquals(48, testSitter.getLateRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetLateRateWhenEndTimeIsEarlierThanTwelvePM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setBedtime(6, PM);
    // testTimes.setEndTime(9, PM);
    // assertEquals(0, testSitter.getLateRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetAsleepRateFromFivePMToFourAMBedAtNinePM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(9, PM);
    // assertEquals(24, testSitter.getAsleepRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetAsleepRateWhenBedTimeIsTheSameAsStartTime() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(6, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(6, PM);
    // assertEquals(48, testSitter.getAsleepRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetAsleepRateWhenBedTimeIsTheEarlierThanStartTime() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(6, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(5, PM);
    // assertEquals(48, testSitter.getAsleepRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetAsleepRateMaxAmount() throws OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(5, PM);
    // assertEquals(56, testSitter.getAsleepRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetAsleepRateWhenEndTimeIsEarlierThanTwelveAM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(9, PM);
    // testTimes.setBedtime(6, PM);
    // assertEquals(24, testSitter.getAsleepRateCost(testTimes));
    // }

    // @Test
    // public void shouldGetAsleepRateWhenBedtimeIsAfterTwelveAM() throws
    // OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(3, AM);
    // assertEquals(0, testSitter.getAsleepRateCost(testTimes));
    // }

    // @Test
    // public void shouldCheckStartIsBeforeEnd() throws OutOfBoundsException {
    // testTimes.setStartTime(5, PM);
    // testTimes.setEndTime(4, AM);
    // testTimes.setBedtime(9, PM);
    // assertTrue(testSitter.checkStartBeforeEnd(testTimes));
    // }

    // @Test
    // public void shouldCheckExceptionThrownStartEnd() throws OutOfBoundsException
    // {
    // thrown.expect(OutOfBoundsException.class);
    // thrown.expectMessage("Start time was not set before end time.");
    // testTimes.setStartTime(10, PM);
    // testTimes.setEndTime(9, PM);
    // testTimes.setBedtime(12, AM);
    // testSitter.checkStartBeforeEnd(testTimes);
    // }

    @Test
    public void shouldGetTotalCostOfTyplicalDay() throws OutOfBoundsException {
        testTimes.setStartTime(5, PM);
        testTimes.setEndTime(4, AM);
        testTimes.setBedtime(9, PM);
        assertEquals(136, testSitter.getTotalCost(testTimes));
    }

    @Test
    public void shouldGetTotalCostForOneNormalHour() throws OutOfBoundsException {
        testTimes.setStartTime(5, PM);
        testTimes.setEndTime(6, PM);
        testTimes.setBedtime(12, AM);
        assertEquals(12, testSitter.getTotalCost(testTimes));
    }

    @Test
    public void shouldGetTotalCostForOneAsleepHour() throws OutOfBoundsException {
        testTimes.setStartTime(5, PM);
        testTimes.setEndTime(6, PM);
        testTimes.setBedtime(5, PM);
        assertEquals(8, testSitter.getTotalCost(testTimes));
    }

    @Test
    public void shouldGetTotalCostAfterMidnightFourHours() throws OutOfBoundsException {
        testTimes.setStartTime(12, AM);
        testTimes.setEndTime(4, AM);
        testTimes.setBedtime(9, PM);
        assertEquals(64, testSitter.getTotalCost(testTimes));
    }

    @Test
    public void shouldGetTotalCostThrowExceptionOnStartTime() throws OutOfBoundsException {
        thrown.expect(OutOfBoundsException.class);
        thrown.expectMessage("The start time wasn't valid, needs to be 5PM-3AM.");
        testTimes.setStartTime(4, AM);
        testTimes.setEndTime(4, AM);
        testTimes.setBedtime(9, PM);
        testSitter.getTotalCost(testTimes);
    }

    @Test
    public void shouldGetTotalCostThrowExceptionOnEndTime() throws OutOfBoundsException {
        thrown.expect(OutOfBoundsException.class);
        thrown.expectMessage("The end time wasn't valid, needs to be 6PM-4AM.");
        testTimes.setStartTime(5, PM);
        testTimes.setEndTime(5, PM);
        testTimes.setBedtime(9, PM);
        testSitter.getTotalCost(testTimes);
    }

    @Test
    public void shouldGetTotalCostThrowExceptionOnStartBeforeEnd() throws OutOfBoundsException {
        thrown.expect(OutOfBoundsException.class);
        thrown.expectMessage("Start time was not set before end time.");
        testTimes.setStartTime(10, PM);
        testTimes.setEndTime(9, PM);
        testTimes.setBedtime(12, AM);
        testSitter.getTotalCost(testTimes);
    }

}
