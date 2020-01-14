package when.ut.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: when
 * @create: 2020-01-13  11:49
 **/
public class Template {
    private String template;
    private Map<String, String> params;

    public Template(String template) {
        this.template = template;
        this.params = new HashMap<>();
    }

    public void set(String key, String value) {
        params.put(key, value);
    }

    public String render() {
        TemplateParser parser = new TemplateParser();
        List<Segment> segments = parser.parse(template);
        return concatenate(segments);
    }

    private String concatenate(List<Segment> segments) {
        StringBuilder result = new StringBuilder();
        for (Segment segment : segments) {
            result.append(segment.render(params));
        }
        return result.toString();
    }

//    private String concatenate(List<String> segments) {
//        StringBuilder result = new StringBuilder();
//        for (String segment : segments) {
//            append(segment, result);
//        }
//        return result.toString();
//    }

//    private void append(String segment, StringBuilder result) {
//        if (isVariable(segment)) {
//            renderVariable(segment, result);
//        } else {
//            result.append(segment);
//        }
//    }

//    private boolean isVariable(String segment) {
//        return segment.startsWith("${") && segment.endsWith("}");
//    }

    private void renderVariable(String segment, StringBuilder result) {
        String variable = segment.substring(2, segment.length() - 1);
        if (!params.containsKey(variable)) {
            throw new MissingValueException("No value for " + segment);
        }
        result.append(params.get(variable));
    }

//    public String render() {
//        String result = replaceVariables();
//        checkMissingValues(result);

//        return result;

//    }

//    private String replaceVariables() {
//        String result = template;
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//            String regex = "\\$\\{" + entry.getKey() + "\\}";
//            result = result.replaceAll(regex, entry.getValue());
//        }
//        return result;
//    }

//    private void checkMissingValues(String result) {
//        String regex = "\\$\\{.+\\}";
//        Pattern pattern = Pattern.compile("\\$\\{.+\\}");
//        Matcher matcher = pattern.matcher(result);
//        if (matcher.find()) {
//            throw new MissingValueException("No value for " + matcher.group());
//        }
//    }
}
