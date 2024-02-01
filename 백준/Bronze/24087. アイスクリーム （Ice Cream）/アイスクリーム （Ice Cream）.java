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

        int S = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        if (S <= A) {
            bw.write(250 + "");
        } else {
            int div = (S - A) / B;
            if ((S - A) % B != 0) {
                div += 1;
            }
            bw.write(div * 100 + 250 + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}