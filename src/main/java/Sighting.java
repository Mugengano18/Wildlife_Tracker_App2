import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sighting {
    public String Rname;
    public String location;
    public String  animal;
    public int id;
    public static ArrayList<Sighting> Sinstances =new ArrayList<>();



    public Sighting(String Rname, String location, String animal){
        this.Rname=Rname;
        this.location=location;
        this.animal=animal;
        Sinstances.add(this);

    }


    public String getRname() {
        return Rname;
    }

    public  String getLocation() {
        return location;
    }

    public String getAnimal() {
        return animal;
    }





    public  void saveto(){
        try(Connection con=DB.sql2o.open()){
            String sql="insert into sightings(rangername,zone,animal) values (:Rname,:location,:animal)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("Rname", this.Rname)
                    .addParameter("location", this.location)
                    .addParameter("animal",this.animal)
                    .executeUpdate()
                    .getKey();
            System.out.println(Rname);

        }
    }

    public static List<Sighting>all(){
        String sql ="SELECT * FROM sightings";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }
}
