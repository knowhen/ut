package when.ut.template;

import java.util.Map;
import java.util.Objects;

/**
 * @author: when
 * @create: 2020-01-13  17:06
 **/
public class Variable implements Segment {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String render(Map<String, String> params) {
        if (!params.containsKey(name)) {
            throw new MissingValueException("No value for ${" + name + "}");
        }
        return params.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return Objects.equals(name, variable.name);
    }

}
