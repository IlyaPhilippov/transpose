import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class test {

    @Test
    public void transpose() throws IOException {
        ArrayList list1 =  new ArrayList<String>();
        list1.add("hello world");
        list1.add("test");
        list1.add("testing method");
        list1.add("русские текст проверка");
        Transposer trans1 = new Transposer(list1);
        int max = trans1.findMax(list1);
        String[][] matrix = trans1.toMatrix(list1, max);
        String output = "testfilenew.txt";
        String wordsize = "10";
        trans1.transpose(matrix, max, output, false, false, wordsize);
        List<String> expected = new ArrayList<>(Files.readAllLines(Paths.get("expected.txt")));
        List<String> actual = new ArrayList<>(Files.readAllLines(Paths.get(output)));
        assertEquals(expected, actual);
    }
    @Test
    public void analise() {
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {""}).analise());
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {"-o", "testfile1"}).analise());
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {"-o", "-o", "-o", "-o", "-o", "-o", "-o", "-o", "-o"}).analise());

    }

}
