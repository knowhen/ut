package when.ut.template;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VariableTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private Map<String, String> params;
    private String name;
    private String expected;

    @Before
    public void setUp() {
        params = new HashMap<>();
        name = "name";
        expected = "myName";
        params.put(name, expected);
    }

    @Test
    public void testRenderVariable() {
        Variable variable = new Variable(name);

        String result = variable.render(params);

        assertEquals(expected, result);
    }

    @Test
    public void missingVariableRaisesException() {
        String name = "missing";
        exception.expect(MissingValueException.class);
        exception.expectMessage("No value for ${" + name + "}");
        Variable variable = new Variable(name);

        String result = variable.render(params);
    }
}