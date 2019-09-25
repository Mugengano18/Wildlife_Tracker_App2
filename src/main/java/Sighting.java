import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private String Rname;
    private String location;
    private String  animal;
    private int id;
    private static ArrayList<Sighting> Sinstances =new ArrayList<>();



    public Sighting(String Rname, String location, String animal){
        this.Rname=Rname;
        this.location=location;
        this.animal=animal;
        Sinstances.add(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animal == sighting.animal &&
                id == sighting.id &&
                Objects.equals(Rname, sighting.Rname) &&
                Objects.equals(location, sighting.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Rname, location, animal, id);
    }

    public String getRname() {
        return Rname;
    }

    public String getLocation() {
        return location;
    }

    public String getAnimal() {
        return animal;
    }



//    public static ArrayList<Sighting> getSinstances() {
//        return Sinstances;
//    }

    public  void save(){
        try(Connection con=DB.sql2o.open()){
            String sql="insert into sightings(rangername ,zone,animal) values (:Rname,:location,:animal)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.Rname)
                    .addParameter("zone", this.location)
                    .addParameter("animal",this.animal)
                    .executeUpdate()
                    .getKey();

        }
    }

    public static List<Sighting> all(){
        String sql ="select * from sightings";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
}
