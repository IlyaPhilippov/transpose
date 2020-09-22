import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void analise() {
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {"testfile1", "testfile2", "testfile3", "testfile4"}).analise());
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {"-a", "10abc"}).analise());
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {"outputname", "inputname"}).analise());
    }
    @Test
    public void main() throws IOException {
        String[] args1 = {"tests/inputfile", "-o", "tests/actual1" , "-a", "10"};
        Main.main(args1);
        List<String> expected1 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected1")));
        List<String> actual1 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual1")));
        assertEquals(expected1, actual1);

        String[] args2 = {"tests/inputfile", "-o", "tests/actual2", "-r"};
        Main.main(args2);
        List<String> expected2 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected2")));
        List<String> actual2 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual2")));
        assertEquals(expected2, actual2);

        String[] args3 = {"tests/inputfile", "-o", "tests/actual3", "-a", "20", "-r", "-t"};
        Main.main(args3);
        List<String> expected3 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected3")));
        List<String> actual3 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual3")));
        assertEquals(expected3, actual3);

        String[] args4 = {"tests/inputfile", "-o", "tests/actual4", "-a", "5", "-t"};
        Main.main(args4);
        List<String> expected4 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected4")));
        List<String> actual4 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual4")));
        assertEquals(expected4, actual4);

        String[] args5 = {"tests/inputfile", "-o", "tests/actual5", "-r", "-t"};
        Main.main(args5);
        List<String> expected5 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected5")));
        List<String> actual5 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual5")));
        assertEquals(expected5, actual5);

        String[] args6 = {"tests/inputfileforT", "-o", "tests/actual6","-t"};
        Main.main(args6);
        List<String> expected6 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected6")));
        List<String> actual6 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual6")));
        assertEquals(expected6, actual6);

        String[] args7 = {"tests/inputfile", "-o", "tests/actual7"};
        Main.main(args7);
        List<String> expected7 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected7")));
        List<String> actual7 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual7")));
        assertEquals(expected7, actual7);

        String[] args8 = {"tests/inputfile", "-o", "tests/actual8", "-a", "15", "-r"};
        Main.main(args8);
        List<String> expected8 = new ArrayList<>(Files.readAllLines(Paths.get("tests/expected8")));
        List<String> actual8 = new ArrayList<>(Files.readAllLines(Paths.get("tests/actual8")));
        assertEquals(expected8, actual8);
    }
}
