import org.sql2o.Connection;
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

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getHealth().equals(newAnimal.getHealth())&&
                    this.getAge().equals(newAnimal.getAge());

        }
    }

    public void save(){
        try(Connection con=DB.sql2o.open()){
            String sql="insert into animals(name,health,age,danger) values (:name,:health,:age,:danger)";
            this.id = (int) con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();

        }
    }
    }


