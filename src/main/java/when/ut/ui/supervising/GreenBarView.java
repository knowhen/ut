package when.ut.ui.supervising;

/**
 * @author: when
 * @create: 2020-03-20  16:51
 **/
public interface GreenBarView {
    void addRunButtonListener(RunButtonListener listener);

    void update(GreenBarModel model);
}
