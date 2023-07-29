import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] botArr = new int[H + 1];
        int[] topArr = new int[H + 1];

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                botArr[a]++;
            } else {
                topArr[H - a + 1]++;
            }
        }

        int[] totalArr = new int[H + 1];

        for (int i = H; i >= 1; i--) {
            botArr[i - 1] += botArr[i];
        }
        for (int i = 0; i < H; i++) {
            topArr[i + 1] += topArr[i];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= H; i++){
            int cur = botArr[i] + topArr[i];
            if(min>cur){
                min=cur;
                cnt = 1;
            } else if(min==cur){
                cnt++;
            }
        }

        bw.write(min+" "+cnt);
        bw.flush();
        bw.close();
        br.close();
    }

}