package when.ut.template;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TemplateParserTest {
    private TemplateParser parser;
    private String text;

    @Before
    public void setUp() {
        parser = new TemplateParser();
    }

    @Test
    public void emptyTemplateRendersAsEmptyString() {
        text = "";
        List<Segment> segments = parser.parse(text);
        assertSegments(segments, new PlainText(text));
    }

    @Test
    public void templateWithOnlyPlainText() {
        text = "plain text only";
        List<Segment> segments = parser.parse(text);
        assertSegments(segments, new PlainText(text));
    }

    @Test
    public void parseMultipleVariables() {
        text = "${a}:${b}:${c}";
        List<Segment> segments = parser.parse(text);
        assertSegments(segments,
                new Variable("a"),
                new PlainText(":"),
                new Variable("b"),
                new PlainText(":"),
                new Variable("c"));
    }

    private void assertSegments(List<Segment> segments, Segment... expected) {
        assertEquals("Numbers of segments doesn't match.", expected.length, segments.size());
        assertEquals(Arrays.asList(expected), segments);
    }
}