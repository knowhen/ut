package when.ut.ui.supervising;

/**
 * @author: when
 * @create: 2020-03-20  16:50
 **/
public class GreenBarController {
    private final GreenBarModel model;
    private final GreenBarView view;

    public GreenBarController(GreenBarModel model, GreenBarView view) {
        this.model = model;
        this.view = view;
        view.addRunButtonListener(new RunButtonListener() {
            @Override
            public void onRunButtonClicked() {
                model.runTests();
                updateView();
            }
        });
    }

    private void updateView() {
        view.update(model);
    }

}
