import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        long sum = 0;

        for(int i = 1; i <= a; i++){
            sum += (i*i*i);
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}