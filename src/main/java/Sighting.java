import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Timer;

public class Sighting {
    private String Rname;
    private String location;
    private int animalId;
    private Timestamp lastseen;



    private static ArrayList<Sighting> Sinstances =new ArrayList<>();


    public Sighting(String Rname, String location){
        this.Rname=Rname;
        this.location=location;
        this.animalId=animalId;
        Sinstances.add(this);
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

    public Timestamp getLastseen() {
        return lastseen;
    }

    public String getDate(){
        return DateFormat.getDateTimeInstance().format(lastseen);
    }

    public static ArrayList<Sighting> getSinstances() {
        return Sinstances;
    }
}
