
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal extends Animals {
    private static ArrayList<EndangeredAnimal> Einstances =new ArrayList<>();
    public EndangeredAnimal(String Ename,String health,String Age){
        this.name=Ename;
        this.health=health;
        this.age=Age;
        Einstances.add(this);
        danger=true;
    }
    public static ArrayList<EndangeredAnimal> Eall() {
        return Einstances;
    }
    @Override
    public boolean equals(Object secondAnimal){
        if(!(secondAnimal instanceof EndangeredAnimal)){
            return false;
        }else{
            EndangeredAnimal newAnimal =(EndangeredAnimal) secondAnimal;
            return this.getName().equals(newAnimal.getName())&&
                    this.getHealth().equals(newAnimal.getHealth())&&
                    this.getAge().equals(newAnimal.getAge());
        }
    }


    public static List<EndangeredAnimal>all(){
        String sql ="select * from animals";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal get(int id){
        try(Connection con =DB.sql2o.open()){
            String sql ="select * from animals where id=:id";
            EndangeredAnimal animal1=con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal1;

        }
    }
}
