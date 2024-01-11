import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            if (str.equals("Poblano")) {
                sum += 1500;
            } else if (str.equals("Mirasol")) {
                sum += 6000;
            } else if (str.equals("Serrano")) {
                sum += 15500;
            } else if (str.equals("Cayenne")) {
                sum += 40000;
            } else if (str.equals("Thai")) {
                sum += 75000;
            } else if (str.equals("Habanero")) {
                sum += 125000;
            }
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }


}