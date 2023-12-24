import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int l = s.length();

        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                bw.write("4");
            } else if (c == 'e') {
                bw.write("3");
            } else if (c == 'i') {
                bw.write("1");
            } else if (c == 'o') {
                bw.write("0");
            } else if (c == 's') {
                bw.write("5");
            } else {
                bw.write(c);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}