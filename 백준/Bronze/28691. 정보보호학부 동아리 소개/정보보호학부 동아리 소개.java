import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char c = s.charAt(0);
        if (c == 'M') {
            bw.write("MatKor");
        } else if (c == 'W') {
            bw.write("WiCys");
        } else if (c == 'C') {
            bw.write("CyKor");
        } else if (c == 'A') {
            bw.write("AlKor");
        } else if (c == '$') {
            bw.write("$clear");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}