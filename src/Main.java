import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Analyzer start = new Analyzer(args);
        start.analise();
        Transposer begin = new Transposer();
        begin.Transpose(start.getOutputname(),start.getrStatus(),start.gettStatus(),start.getWordsize(),start.getInputname());
    }
}
