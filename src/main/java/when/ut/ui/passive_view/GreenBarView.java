package when.ut.ui.passive_view;

import when.ut.ui.supervising.RunButtonListener;

public interface GreenBarView {
    void addRunButtonListener(RunButtonListener listener);

    void setBarColor(Color  color);
}
