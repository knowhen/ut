package when.ut.ui.plot_map.view;

import java.awt.*;

/**
 * @author: when
 * @create: 2020-03-21  10:14
 **/
public interface PlotMapCanvas {
    void plot(Point point);

    void addRemoveListener(PointEventListener listener);

    void clear();
}
