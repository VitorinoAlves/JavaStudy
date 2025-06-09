package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testFilter(){
        String pessoasString = "Test Name One - M, Test Name Two - F, Test Name Three - M, Test Name Four - F, Test Name Five - F";
        List<String> actual = Main.filtraListaMulheres(pessoasString);
        List<String> expected = Arrays.asList("Test Name Two - F", "Test Name Four - F", "Test Name Five - F");
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterEmptyList(){
        String pessoasString = "Test Name One - M, Test Name Three - M, Test Name Five - M";
        List<String> actual = Main.filtraListaMulheres(pessoasString);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFilterForEach(){
        String pessoasString = "Test Name One - M, Test Name Two - F, Test Name Three - M, Test Name Four - F, Test Name Five - F";
        List<String> actual = Main.filtraListaMulheres(pessoasString);
        actual.forEach(pessoa -> {
            assertTrue(pessoa.endsWith("F"));
        });
    }

}