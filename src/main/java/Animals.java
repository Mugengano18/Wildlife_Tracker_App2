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


@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Animals animals = (Animals) o;
    return id == animals.id &&
            danger == animals.danger &&
            Objects.equals(name, animals.name) &&
            Objects.equals(health, animals.health) &&
            Objects.equals(age, animals.age);
}

    @Override
    public int hashCode() {
        return Objects.hash(id, name, health, age, danger);
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


