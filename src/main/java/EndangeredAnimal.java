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
}
