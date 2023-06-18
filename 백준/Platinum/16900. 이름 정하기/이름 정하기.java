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

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        long n = Long.parseLong(st.nextToken());

        int L = str.length();
        int[] pi = getPi(L, str);

        long lL = L;
        long lpi = pi[L - 1];

        long result = (lL * n) - (lpi * (n - 1));

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }


}