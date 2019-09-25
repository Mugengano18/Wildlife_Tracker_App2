import org.sql2o.Connection;
import java.util.ArrayList;
import java.util.Objects;

public class Sighting {
    private String Rname;
    private String location;
    private int animalId;
    private int id;
    private static ArrayList<Sighting> Sinstances =new ArrayList<>();


    public Sighting(String Rname, String location,int animalId){
        this.Rname=Rname;
        this.location=location;
        this.animalId=animalId;
        Sinstances.add(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animalId == sighting.animalId &&
                id == sighting.id &&
                Objects.equals(Rname, sighting.Rname) &&
                Objects.equals(location, sighting.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Rname, location, animalId, id);
    }

    public String getRname() {
        return Rname;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimalId() {
        return animalId;
    }


    public static ArrayList<Sighting> getSinstances() {
        return Sinstances;
    }

    public  void save(){
        try(Connection con=DB.sql2o.open()){
            String sql="insert into sightings(name ,zone,animal,timeseen) values (:name,:location,:animalId,now())";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.Rname)
                    .addParameter("health", this.location)
                    .executeUpdate()
                    .getKey();

        }
    }
}
