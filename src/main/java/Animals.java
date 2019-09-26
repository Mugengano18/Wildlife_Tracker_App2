import org.sql2o.Connection;

import java.util.Objects;

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
        System.out.println(danger);
        return danger;
    }



    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }




    public  void save(){
        try(Connection con=DB.sql2o.open()){
            String sql="insert into animals(name,health,age,danger) values (:name,:health,:age,:danger)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age",this.age)
                    .addParameter("danger",this.danger)
                    .executeUpdate()
                    .getKey();

        }
    }

    }


