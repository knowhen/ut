package when.ut.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RegexLearningTest {
    @Test
    public void testHowGroupCountWord() {
        String text = "The needle shop sells needles";
        String regex = "(needle)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        assertEquals(1, matcher.groupCount());
    }

    @Test
    public void testFindStartAndEnd() {
        String text = "The needle shop sells needles";
        String regex = "needle";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        assertTrue(matcher.find());
        assertEquals("Wrong start index of 1st match", 4, matcher.start());
        assertEquals("Wrong end index of 1st match", 10, matcher.end());

        assertTrue(matcher.find());
        assertEquals("Wrong start index of 2nd match", 22, matcher.start());
        assertEquals("Wrong end index of 2nd match", 28, matcher.end());

        assertFalse("Shouldn't hava any more matches", matcher.find());
    }
}