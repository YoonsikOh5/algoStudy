import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N;
    static int tp[][];

    // dp[i] N = i 일때의 최댓값
    static int dp[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tp = new int[N+1][2];

        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tp[i][0] = t;
            tp[i][1] = p;

            int endday = (i + t) - 1;
            if(hm.containsKey(endday)){
                hm.get(endday).add(i);
            } else {
                hm.put(endday, new LinkedList<Integer>());
                hm.get(endday).add(i);
            }
        }

        dp = new int[N+1];
        dp[0] = 0;

        for(int i = 1; i <= N; i++) {
            dp[i] = dp[i-1];
            
            if(hm.containsKey(i)){
                List<Integer> ls = hm.get(i);
                for (Integer l : ls) {
                    dp[i] = Math.max(dp[i], tp[l][1]+dp[i-tp[l][0]]);
                }
            }
        }

        bw.write(dp[N]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}