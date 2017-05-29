/**
 * Created by Arkadiusz Nowak on 29.05.2017.
 */
public interface Effectable {

    void activate();
    void deactivate();
    void run(long currentTic);
    void release();

}
