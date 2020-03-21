package when.ut.ui.plot_map;

import abbot.finder.matchers.NameMatcher;
import abbot.tester.ComponentTester;
import junit.extensions.abbot.ComponentTestFixture;
import when.ut.ui.plot_map.view.PlotAdditionListener;
import when.ut.ui.plot_map.view.PlotMapViewImpl;

import java.awt.*;

public class PlotMapViewImplTest extends ComponentTestFixture implements PlotAdditionListener {
    private ComponentTester tester = new ComponentTester();
    private Point addedPlot;
//    private PlotMapCanvasStub canvas;

    public void setUp() throws Exception {
        super.setUp();
        addedPlot = null;
//        canvas = new PlotMapCanvasStub();

        PlotMapViewImpl view = new PlotMapViewImpl();
//        PlotMapViewImpl view = new PlotMapViewImpl() {
//            protected PlotMapCanvas createCanvas() {
//                return canvas;
//            }
//        };
        view.registerAdditionListener(this);
        showFrame(view);
    }

    @Override
    public void plotWasAdded(Point plot) {
        addedPlot = plot;
    }

    public void testAdditionEventGetsTriggered() throws Exception {
        Point point = new Point(3, 5);
        typeIntoTextField("x_coord_textfield", "" + point.x);
        typeIntoTextField("y_coord_textfield", "" + point.y);
        tester.actionClick(namedComponent("add_button"));
        assertEquals(point, addedPlot);
    }

    private Component namedComponent(String name) throws Exception {
        return getFinder().find(new NameMatcher(name));
    }

    private void typeIntoTextField(String name, String value) throws Exception {
        tester.actionKeyString(namedComponent(name), value);
    }


}