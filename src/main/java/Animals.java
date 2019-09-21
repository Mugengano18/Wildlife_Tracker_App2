
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
public abstract class Animals {
    public int  id;
    public String name;
    public boolean danger;
    public Timer timer;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public boolean isEndangered() {
        return danger;
    }





}
