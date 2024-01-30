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

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int rank = Integer.parseInt(br.readLine());

            bw.write("Case #" + i + ": ");
            if (rank > 4500) {
                bw.write("Round 1\n");
            } else if (rank > 1000) {
                bw.write("Round 2\n");
            } else if (rank > 25) {
                bw.write("Round 3\n");
            } else {
                bw.write("World Finals\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}