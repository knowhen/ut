package when.ut.ui.plot_map.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: when
 * @create: 2020-03-21  10:26
 **/
public class PlotMapCanvasImpl extends Canvas implements PlotMapCanvas {
    private List<Point> plots = new ArrayList<>();

    public PlotMapCanvasImpl() {
        setSize(200, 100);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public void plot(Point point) {
        plots.add(point);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);

        Point previous = null;
        for (Point current : plots) {
            if (previous == null) {
                previous = current;
            }
            g.drawLine(previous.x, previous.y, current.x, current.y);
            previous = current;
        }
    }

    @Override
    public void addRemoveListener(final PointEventListener listener) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                if (plots.contains(point)) {
                    listener.onPointEvent(point);
                }
            }
        });
    }

    @Override
    public void clear() {

    }
}
