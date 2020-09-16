import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transposer {
    private List<String> text;

    public Transposer (List<String> text){
        this.text = text;
    }


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
    public String[][] toMatrix (List<String> text , int max){
        String[][] textArr = new String[text.size()][max];
        for (int i = 0; i  < text.size(); i++) {
            String[] temp = text.get(i).trim().split(" +");
            for (int j = 0; j < temp.length; j++){
                textArr[i][j] = temp[j];
            }
        }
        return textArr;
    }
    public void transpose (String[][] text , int max , String outputname , boolean rStatus , boolean tStatus , String wordsize) throws IOException {
        String[][] textArr = new String[max][text.length];
        int size = Integer.parseInt(wordsize);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < text.length; j++) {
                if (text[j][i] == null){
                    text[j][i] = " ";
                }
                if (tStatus){
                    if (text[j][i].length() > size) text[j][i] = text[j][i].substring(0,size -1);
                }
                if(rStatus) {
                    textArr[i][j] = String.format("%" + size + "s", text[j][i]);
                }else textArr[i][j] = String.format("%-" + size + "s", text[j][i]);
            }
        }
        if (outputname != null){
            FileOutputStream out = new FileOutputStream(outputname);
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < text.length; j++) {
                    out.write(textArr[i][j].getBytes());
                }
                out.write("\n".getBytes());
            }
        } else {
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < text.length; j++) {
                    System.out.print(textArr[i][j]);
                }
                System.out.print("\n");
            }
        }
    }

    }