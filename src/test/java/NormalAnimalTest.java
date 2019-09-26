import org.junit.Test;

import static org.junit.Assert.*;

public class NormalAnimalTest {
    @Test
    public void endangered_instatiateCorrectly(){
        NormalAnimal testNormal= new NormalAnimal("cat","sick","adult",false);
        assertEquals(true,testNormal instanceof  NormalAnimal);
    }

    @Test
    public void Endangerd_instantiateName_String(){
        NormalAnimal testNormal= new NormalAnimal("cat","sick","adult",false);
        assertEquals("cat",testNormal.getName());
    }
    @Test
    public void Endangerd_instantiatehealth_String(){
        NormalAnimal testNormal= new NormalAnimal("tiger","sick","adult",false);
        assertEquals("sick",testNormal.getHealth());
    }
    @Test
    public void Endangerd_instantiateAge_String(){
        NormalAnimal testNormal= new NormalAnimal("tiger","sick","adult",false);
        assertEquals("adult",testNormal.getAge());
    }
}