import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class NormalAnimal extends Animals {
    private static ArrayList<NormalAnimal> Ninstances =new ArrayList<>();
    public NormalAnimal(String name,String health,String age,boolean danger){
        this.name=name;
        this.health=health;
        this.age=age;
        Ninstances.add(this);
        danger=false;
    }
    public static ArrayList<NormalAnimal>NAll() {
        return Ninstances;
    }
    public static List<NormalAnimal>all(){
        String sql="select *from animals";
        try(Connection connect=DB.sql2o.open()){
            return connect.createQuery(sql).executeAndFetch(NormalAnimal.class);
        }
    }

    public static NormalAnimal get(int id){
        try (Connection connect=DB.sql2o.open()){
            String sql="select * from animals where id=:id";
            NormalAnimal animal2=connect.createQuery(sql).addParameter("id",id).executeAndFetchFirst(NormalAnimal.class);
            return animal2;
        }
    }
//    @Override
//    public void save(){
//        try(Connection con=DB.sql2o.open()){
//            String sql="update animals set name=:name, health=:health, age=:age where id=:id";
//            this.id = (int) con.createQuery(sql,true)
//                    .addParameter("name", this.name)
//                    .addParameter("health", this.health)
//                    .addParameter("age",this.age)
//                    .executeUpdate()
//                    .getKey();
//
//        }
//    }
}
