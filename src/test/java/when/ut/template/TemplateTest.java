package when.ut.template;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TemplateTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();
    private Template template;
    private String text;

    @Before
    public void setUp() {
        text = "Hello, ${five}${six}${seven}!";
        template = new Template(text);

        template.set("five", "伍");
        template.set("six", "六");
        template.set("seven", "柒");
    }

    @Test
    public void multiVariables() {
        String expected = "Hello, 伍六柒!";

        assertTemplateRenderResultEqualsTo(expected);
    }

    @Test
    public void unknownVariablesAreIgnored() {
        template.set("one", "壹");
        String expected = "Hello, 伍六柒!";

        assertTemplateRenderResultEqualsTo(expected);
    }

    @Test
    public void missingValueRaisesException() {
        expected.expect(MissingValueException.class);
        expected.expectMessage("No value for ${foo}");
        Template foo = new Template("${foo}");
        foo.render();
    }

    private void assertTemplateRenderResultEqualsTo(String expected) {
        assertEquals(expected, template.render());
    }
}