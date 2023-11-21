import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        for (int i = 1; i <= 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                char cur = str.charAt(j);
                if (cur == 'K') {
                    result += 0;
                } else if (cur == 'k') {
                    result -= 0;
                } else if (cur == 'P') {
                    result += 1;
                } else if (cur == 'p') {
                    result -= 1;
                } else if (cur == 'N') {
                    result += 3;
                } else if (cur == 'n') {
                    result -= 3;
                } else if (cur == 'B') {
                    result += 3;
                } else if (cur == 'b') {
                    result -= 3;
                } else if (cur == 'R') {
                    result += 5;
                } else if (cur == 'r') {
                    result -= 5;
                } else if (cur == 'Q') {
                    result += 9;
                } else if (cur == 'q') {
                    result -= 9;
                }
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

}