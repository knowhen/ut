package when.ut.ui.plot_map;

import when.ut.ui.plot_map.model.PlotMapModel;
import when.ut.ui.plot_map.presenter.PlotMapPresenter;
import when.ut.ui.plot_map.view.PlotMapView;
import when.ut.ui.plot_map.view.PlotMapViewImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author: when
 * @create: 2020-03-21  10:40
 **/
public class App extends JFrame {

    public App() {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new PlotMapViewImpl(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
        PlotMapModel model = new PlotMapModel();
        PlotMapViewImpl view = new PlotMapViewImpl();
        PlotMapPresenter presenter = new PlotMapPresenter(model, view);
    }
}
