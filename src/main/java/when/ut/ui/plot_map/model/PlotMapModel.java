package when.ut.ui.plot_map.model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

/**
 * @author: when
 * @create: 2020-03-21  09:31
 **/
public class PlotMapModel {
    private List<Point> plots = new ArrayList<>();

    public void add(Point plot) {
        plots.add(plot);
    }

    public void remove(Point plot) {
        plots.remove(plot);
    }

    public List<Point> getPlots() {
        return Collections.unmodifiableList(plots);
    }
}
