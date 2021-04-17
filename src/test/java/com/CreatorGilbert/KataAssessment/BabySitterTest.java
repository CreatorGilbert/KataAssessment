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
