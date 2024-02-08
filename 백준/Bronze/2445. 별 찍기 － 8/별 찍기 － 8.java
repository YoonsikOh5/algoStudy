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

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            int blank = n - i;
            for (int j = 1; j <= blank; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= blank; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            int blank = n - i;
            for (int j = 1; j <= blank; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= blank; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}