import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Test
    public void endangered_instatiateCorrectly(){
        EndangeredAnimal testEndanger= new EndangeredAnimal("tiger","sick","adult",true);
        assertEquals(true,testEndanger instanceof  EndangeredAnimal);
    }

    @Test
    public void Endangerd_instantiateName_String(){
        EndangeredAnimal testEndanger= new EndangeredAnimal("tiger","sick","adult",true);
        assertEquals("tiger",testEndanger.getName());
    }
    @Test
    public void Endangerd_instantiatehealth_String(){
        EndangeredAnimal testEndanger= new EndangeredAnimal("tiger","sick","adult",true);
        assertEquals("sick",testEndanger.getHealth());
    }
    @Test
    public void Endangerd_instantiateAge_String(){
        EndangeredAnimal testEndanger= new EndangeredAnimal("tiger","sick","adult",true);
        assertEquals("adult",testEndanger.getAge());
    }


}