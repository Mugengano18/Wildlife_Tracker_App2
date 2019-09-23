
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public abstract class Animals {
    public int  id;
    public String name;
    public String health;
    public String age;
    public boolean danger;
//    public static ArrayList<Animals> instances =new ArrayList<>();


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public boolean isDanger() {
        return danger;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

//    @Override
//    public boolean equals(object secondAnimal){
//        if (!(secondAnimal in))
//    }

}
