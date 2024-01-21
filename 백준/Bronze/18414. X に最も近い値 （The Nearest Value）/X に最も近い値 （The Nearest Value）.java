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

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int minAbs = Integer.MAX_VALUE;
        int minidx = -1;

        for(int i = b; i <= c; i++){
            int cur = Math.abs(a - i);
            if(minAbs > cur){
                minAbs = cur;
                minidx = i;
            }
        }

        bw.write(minidx+"");
        bw.flush();
        bw.close();
        br.close();
    }

}