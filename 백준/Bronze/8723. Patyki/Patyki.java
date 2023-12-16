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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if ((a == b) && (b == c)) {
            bw.write(2 + "");
        } else {
            if (((a * a) + (b * b)) == (c * c)) {
                bw.write(1 + "");
            } else if (((a * a) + (c * c)) == (b * b)) {
                bw.write(1 + "");
            } else if (((c * c) + (b * b)) == (a * a)) {
                bw.write(1 + "");
            } else {
                bw.write(0 + "");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}