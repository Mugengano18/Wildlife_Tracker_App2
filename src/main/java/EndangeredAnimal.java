import java.util.ArrayList;

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
}
