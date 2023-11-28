import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }


}
