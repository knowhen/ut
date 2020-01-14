package when.ut.template;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author: when
 * @create: 2020-01-13  15:16
 **/
public class TemplatePerformanceTest {
    private Template template;

    @Before
    public void setUp() {
        String templateText = "" +
                "${one} ${two} ${three} ${four} ${five}\n" +
                "go up the mountain for tigers\n" +
                "missing tigers\n" +
                "meeting squirrels\n" +
                "how many of them\n" +
                "let me count the number";
        template = new Template(templateText);
    }

    @Test
    public void render24WordsTemplateAnd5Variables() {
        long expected = 100L;
        long time = System.currentTimeMillis();
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
        template.set("four", "4");
        template.set("five", "5");
        template.render();
        time = System.currentTimeMillis() - time;

        assertTrue("Rendering template took " + time + "ms while the target was " + expected + "ms",
                time <= expected);
    }
}
