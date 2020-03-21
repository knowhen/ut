package when.ut.ui.passive_view;

import when.ut.ui.supervising.RunButtonListener;

/**
 * @author: when
 * @create: 2020-03-21  09:03
 **/
public class GreenBarController {
    private final GreenBarModel model;
    private final GreenBarView view;

    public GreenBarController(final GreenBarModel model, final GreenBarView view) {
        this.model = model;
        this.view = view;
        view.addRunButtonListener(() -> {
            model.runTests();
            updateView();
        });
        updateView();
    }

    private void updateView() {
        boolean passed = (model.numberOfFailures() == 0);
        Color color = passed ? Colors.testsPassed() : Colors.testsFailed();
        view.setBarColor(color);
    }
}
