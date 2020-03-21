package when.ut.ui.plot_map.view;

import when.ut.ui.plot_map.model.PlotMapModel;

import javax.swing.*;
import java.awt.*;

/**
 * @author: when
 * @create: 2020-03-21  09:47
 **/
public class PlotMapViewImpl extends JPanel implements PlotMapView {
    private PlotAdditionListener additionListener;
    private JTextField xCoordField, yCoordField;
    private JButton addButton;
    private PlotMapCanvas canvas;

    public PlotMapViewImpl() {
        createWidgets();

        add(xCoordField);
        add(yCoordField);
        add(addButton);
        setSize(300, 300);
    }

    @Override
    public void registerAdditionListener(PlotAdditionListener listener) {
        this.additionListener = listener;
    }

    @Override
    public void registerRemovalListener(PlotRemovalListener listener) {

    }

    @Override
    public void drawPlotMap(PlotMapModel model) {
        canvas.clear();
        for (Point point : model.getPlots()) {
            canvas.plot(point);
        }
    }

    protected PlotMapCanvas createCanvas() {
        return new PlotMapCanvasImpl();
    }

    private void createWidgets() {
        xCoordField = createTextField("x_coord_textfield");
        yCoordField = createTextField("y_coord_textfield");

        addButton = new JButton();
        addButton.setName("add_button");
        addButton.addActionListener((event) -> {
            int x = valuesAsInt(xCoordField);
            int y = valuesAsInt(yCoordField);
            additionListener.plotWasAdded(new Point(x, y));
        });

        canvas = createCanvas();
    }

    private JTextField createTextField(String name) {
        JTextField textField = new JTextField();
        textField.setName(name);
        return textField;
    }

    private int valuesAsInt(JTextField textField) {
        return Integer.parseInt(textField.getText());
    }
}
