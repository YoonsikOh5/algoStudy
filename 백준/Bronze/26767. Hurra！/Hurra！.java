import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (i % 7 == 0 && i % 11 == 0) {
                bw.write("Wiwat!\n");
            } else if(i % 7 == 0){
                bw.write("Hurra!\n");
            } else if(i % 11 == 0){
                bw.write("Super!\n");
            } else {
                bw.write(i+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}