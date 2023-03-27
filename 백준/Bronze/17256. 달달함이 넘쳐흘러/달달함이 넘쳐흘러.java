import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aarr = new int[3];
        for(int i = 0; i < 3; i++){
            aarr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] carr = new int[3];
        for(int i = 0; i < 3; i++){
            carr[i] = Integer.parseInt(st.nextToken());
        }

        int[] barr = new int[3];
        barr[0] = carr[0] - aarr[2];
        barr[1] = carr[1] / aarr[1];
        barr[2] = carr[2] - aarr[0];

        for(int i = 0; i < 3; i++){
            bw.write(barr[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}