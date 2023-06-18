import java.io.*;
import java.util.*;

public class Main {

    public static int[] getPi(int L, String str) {

        int[] pi = new int[L];

        int j = 0;

        for (int i = 1; i < L; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        while (!str.equals(".")) {

            int L = str.length();

            int[] pi = getPi(L, str);

            int m = pi[L - 1];

            // 안 나눠떨어지면 1임
            if (L % (L - m)==0){
                bw.write(L/(L-m)+"\n");
            } else {
                bw.write("1\n");
            }
            str = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }


}