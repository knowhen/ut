package when.ut.template;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: when
 * @create: 2020-01-13  15:59
 **/
public class TemplateParser {

    public List<Segment> parse(String template) {
        List<Segment> segments = new ArrayList<>();
        int index = collectSegments(template, segments);
        addTail(template, segments, index);
        addEmptyStringIfTemplateIsEmpty(segments);
        return segments;
    }

    private int collectSegments(String template, List<Segment> segments) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(template);
        int index = 0;
        while (matcher.find()) {
            addPrecedingPlainText(template, segments, matcher, index);
            addVariable(template, segments, matcher.start(), matcher.end());
            index = matcher.end();
        }
        return index;
    }

    private void addPrecedingPlainText(String template, List<Segment> segments, Matcher matcher, int index) {
        if (matcher.start() != index) {
            PlainText plainText = new PlainText(template.substring(index, matcher.start()));
            segments.add(plainText);
        }
    }

    private void addVariable(String template, List<Segment> segments, int start, int end) {
        // template.substring(start, end) is "${name}", we only need "name".
        Variable variable = new Variable(template.substring(start + 2, end - 1));
        segments.add(variable);
    }

    private void addTail(String template, List<Segment> segments, int index) {
        if (index < template.length()) {
            PlainText plainText = new PlainText(template.substring(index));
            segments.add(plainText);
        }
    }

    private void addEmptyStringIfTemplateIsEmpty(List<Segment> segments) {
        if (segments.isEmpty()) {
            PlainText plainText = new PlainText("");
            segments.add(plainText);
        }
    }
}
