import org.junit.Test;

import static org.junit.Assert.*;

public class NormalAnimalTest {
    @Test
    public void endangered_instatiateCorrectly(){
        NormalAnimal testNormal= new NormalAnimal("cat","sick","adult");
        assertEquals(true,testNormal instanceof  NormalAnimal);
    }

    @Test
    public void Endangerd_instantiateName_String(){
        NormalAnimal testNormal= new NormalAnimal("cat","sick","adult");
        assertEquals("cat",testNormal.getName());
    }
    @Test
    public void Endangerd_instantiatehealth_String(){
        NormalAnimal testNormal= new NormalAnimal("tiger","sick","adult");
        assertEquals("sick",testNormal.getHealth());
    }
    @Test
    public void Endangerd_instantiateAge_String(){
        NormalAnimal testNormal= new NormalAnimal("tiger","sick","adult");
        assertEquals("adult",testNormal.getAge());
    }
}