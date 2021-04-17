package com.CreatorGilbert.KataAssessment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SetTimesTest {
    private final boolean PM = true, AM = false;
    private SetTimes testTimes;
    private final int FIVEPM = 0, ELEVENPM = 6, TWELVEAM = 7, FOURAM = 11;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createUsedObjects() {
        testTimes = new SetTimes();
    }

    @Test
    public void shouldCheckGivenTimeAtFivePMIsValid() throws OutOfBoundsException {
        assertEquals(FIVEPM, testTimes.transformTime(5, PM));
    }

    @Test
    public void shouldCheckGivenTimeAtElevenPMIsValid() throws OutOfBoundsException {
        assertEquals(ELEVENPM, testTimes.transformTime(11, PM));
    }

    @Test
    public void shouldCheckGivenTimeAtFourAMIsValid() throws OutOfBoundsException {
        assertEquals(FOURAM, testTimes.transformTime(4, AM));
    }

    @Test
    public void shouldCheckGivenTimeAtTwelveAMIsValid() throws OutOfBoundsException {
        assertEquals(TWELVEAM, testTimes.transformTime(12, AM));
    }

    @Test
    public void shouldCheckGivenTimeAt4PMThrowsException() throws OutOfBoundsException {
        thrown.expect(OutOfBoundsException.class);
        thrown.expectMessage("The time wasn't valid. Time given was: 4 PM");
        testTimes.transformTime(4, PM);
    }

    @Test
    public void shouldCheckGiventimeAt5AMThrowsException() throws OutOfBoundsException{
        thrown.expect(OutOfBoundsException.class);
        thrown.expectMessage("The time wasn't valid. Time given was: 5 AM");
        testTimes.transformTime(5, AM);
    }
}

