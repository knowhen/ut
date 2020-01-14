package when.ut.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PlainTextTest {
    @Test
    public void testRenderPlainText() {
        Map<String, String> params = new HashMap<>();
        String text = "abc def";
        PlainText plainText = new PlainText(text);

        String result = plainText.render(params);

        assertEquals(text, result);
    }
}