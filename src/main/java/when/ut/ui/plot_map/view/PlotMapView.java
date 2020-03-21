package when.ut.ui.plot_map.view;

import when.ut.ui.plot_map.model.PlotMapModel;

public interface PlotMapView {
    void registerAdditionListener(PlotAdditionListener listener);

    void registerRemovalListener(PlotRemovalListener listener);

    void drawPlotMap(PlotMapModel model);

}
