import java.util.ArrayList;

public class NormalAnimal extends Animals {
    private static ArrayList<NormalAnimal> Ninstances =new ArrayList<>();
    public NormalAnimal(String name,String health,String age){
        this.name=name;
        this.health=health;
        this.age=age;
        Ninstances.add(this);
        danger=false;
    }
    public static ArrayList<NormalAnimal>NAll() {
        return Ninstances;
    }
}
