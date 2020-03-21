package when.ut.ui.plot_map.presenter;

import when.ut.ui.plot_map.model.PlotMapModel;
import when.ut.ui.plot_map.view.PlotMapView;

/**
 * @author: when
 * @create: 2020-03-21  10:54
 **/
public class PlotMapPresenter {
    private final PlotMapModel model;
    private final PlotMapView view;

    public PlotMapPresenter(PlotMapModel model, PlotMapView view) {
        this.model = model;
        this.view = view;
        view.registerAdditionListener(point ->
        {
            model.add(point);
            updateView();
        });
    }

    private void updateView() {
        view.drawPlotMap(model);
    }
}
