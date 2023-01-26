import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] abc = new int[3];
        abc[0] = Integer.parseInt(br.readLine());
        abc[1] = Integer.parseInt(br.readLine());
        abc[2] = Integer.parseInt(br.readLine());

        Arrays.sort(abc);

        bw.write(abc[1]+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
