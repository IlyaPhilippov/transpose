import java.io.IOException;
import java.nio.file.NoSuchFileException;


public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Analyzer start = new Analyzer(args);
            start.analise();
            Transposer begin = new Transposer();
            begin.Transpose(start.getOutputname(), start.getrStatus(), start.gettStatus(), start.getWordsize(), start.getInputname());
        }catch (NumberFormatException e){
            System.err.println("Incorrect word size");
        }catch (IllegalArgumentException e){
            System.err.println("Too much arguments");
        }catch(NoSuchFileException e){
            System.err.println("Invalid file name entered. Correct file name or add the full path to the file!");
        }
    }
}
