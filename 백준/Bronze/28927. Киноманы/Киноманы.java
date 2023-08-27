import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] max = new int[3];
        int maxsum = 0;
        for(int i = 0; i < 3; i++){
            max[i] = Integer.parseInt(st.nextToken());
        }
        maxsum += max[0]* 3;
        maxsum += max[1]* 20;
        maxsum += max[2]* 120;

        st = new StringTokenizer(br.readLine());
        int melsum = 0;
        int[] mel = new int[3];
        for(int i = 0; i < 3; i++){
            mel[i] = Integer.parseInt(st.nextToken());
        }
        melsum += mel[0]* 3;
        melsum += mel[1]* 20;
        melsum += mel[2]* 120;

        if(maxsum > melsum){
            bw.write("Max");
        } else if (maxsum < melsum){
            bw.write("Mel");
        } else {
            bw.write("Draw");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}