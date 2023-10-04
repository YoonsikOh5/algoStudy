import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        boolean[] arr = new boolean[30];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int i1 = c - 'A';
            arr[i1] = true;
        }

        String mobis = "MOBIS";
        boolean isPos = true;
        for (int i = 0; i < 5; i++) {
            char c = mobis.charAt(i);
            int i1 = c - 'A';
            if (arr[i1] == false) {
                isPos = false;
                break;
            }
        }
        if (isPos) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();

    }


}