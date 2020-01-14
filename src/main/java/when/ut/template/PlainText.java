package when.ut.template;

import java.util.Map;
import java.util.Objects;

/**
 * @author: when
 * @create: 2020-01-13  17:05
 **/
public class PlainText implements Segment {
    private String plainText;

    public PlainText(String plainText) {
        this.plainText = plainText;
    }

    @Override
    public String render(Map<String, String> params) {
        return plainText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlainText plainText1 = (PlainText) o;
        return Objects.equals(plainText, plainText1.plainText);
    }

}
