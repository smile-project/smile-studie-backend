package de.smile_studie.restcontroller;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by mss on 11.10.17.
 */
public class QuestionaireControllerTest {
    @Test
    public void timePassed() throws Exception {
        // now as base time
        LocalDateTime now = LocalDateTime.now();

        // in the future or not far enough in the past
        LocalDateTime d1 = now.plusDays(2);
        LocalDateTime d2 = now.minusDays(6);

        // at least 7 days behind
        LocalDateTime d3 = now.minusDays(7);

        assertFalse(QuestionaireController.timePassed(Timestamp.valueOf(d1)));
        assertFalse(QuestionaireController.timePassed(Timestamp.valueOf(d2)));
        assertTrue(QuestionaireController.timePassed(Timestamp.valueOf(d3)));
    }

}