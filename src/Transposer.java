import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transposer {
    public int findMax (List<String> text){
        int max = 0;
        for (String s : text) {
            String[] temp = s.trim().split(" +");
            if (temp.length > max) {
                max = temp.length;
            }
        }
        return max;
    }
    public String[][] toMatrix (int max,List<String> text){
        String[][] textArr = new String[text.size()][max];
        for (int i = 0; i  < text.size(); i++) {
            String[] temp = text.get(i).trim().split(" +");
            for (int j = 0; j < temp.length; j++){
                textArr[i][j] = temp[j];
            }
        }
        return textArr;
    }
    public void transpose (String[][] text , int max , String outputname , boolean rStatus , boolean tStatus , Integer wordsize) throws IOException {
        String[][] textArr = new String[max][text.length];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < text.length; j++) {
                if (text[j][i] == null){
                    text[j][i] = "";
                }
                if (tStatus){
                    if (text[j][i].length() > wordsize) text[j][i] = text[j][i].substring(0,wordsize - 1);
                }
                if (rStatus) {
                    textArr[i][j] = String.format("%" + wordsize + "s", text[j][i]);
                }else
                    if (wordsize != null) {textArr[i][j] = String.format("%-" + wordsize + "s", text[j][i]);}
                    else textArr[i][j] = text[j][i];
            }
        }
        OutputStream out;
        if (outputname != null) {
            out = new FileOutputStream(outputname);
        } else {
            out = System.out;
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < text.length; j++) {
                    writer.write(textArr[i][j]);
                    writer.write(' ');
                }
                writer.newLine();
            }
        }
    }
    public void Transpose (String output , boolean rStaus , boolean tStatus , Integer wordsize , String input) throws IOException {
            List<String> text = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            if (input != null) {
                text.addAll(Files.readAllLines(Paths.get(input)));
            } else {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    text.add(line);
                }
            }
            Transposer trans = new Transposer();
            int max = trans.findMax(text);
            String[][] txt = trans.toMatrix(max,text);
            trans.transpose(txt, max, output, rStaus, tStatus, wordsize);
        }
    }