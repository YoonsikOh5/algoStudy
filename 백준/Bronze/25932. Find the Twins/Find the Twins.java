import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean iszack = false;
            boolean ismack = false;
            int[] arr = new int[10];
            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 10; j++) {
                int cur = arr[j];
                if(cur == 17) iszack = true;
                if(cur == 18) ismack = true;
                bw.write(cur+" ");
            }
                bw.write("\n");

            if(iszack && ismack){
                bw.write("both\n");
            } else if(iszack){
                bw.write("zack\n");
            } else if (ismack) {
                bw.write("mack\n");
            } else {
                bw.write("none\n");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}