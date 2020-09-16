import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        try {
            Analyzer start = new Analyzer(args);
            start.analise();
            List<String> text = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            if (start.getInputname() != null) {
                text.addAll(Files.readAllLines(Paths.get("src/" + start.getInputname())));
            } else {
                while (true) {
                    String line = in.nextLine();
                    if (line.equals("/stop")) break;
                    text.add(line);
                }
            }
            Transposer trans = new Transposer(text);
            int max = trans.findMax(text);
            String[][] txt = trans.toMatrix(text, max);
            trans.transpose(txt, max, start.getOutputname(), start.getrStatus(), start.gettStatus(), start.getWordsize());
        } catch (NoSuchFileException e){
           throw new NoSuchFileException("Error");
        }
    }
}
