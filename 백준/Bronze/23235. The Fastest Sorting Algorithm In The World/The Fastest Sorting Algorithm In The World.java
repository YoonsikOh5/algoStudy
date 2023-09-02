import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean run = true;
        int caseN = 1;
        while (run) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                run = false;
            } else {
                bw.write("Case " + caseN + ": Sorting... done!\n");
                caseN++;
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}