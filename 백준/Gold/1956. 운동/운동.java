import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int[][] edgeM;

    static final int INF = 5000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeM = new int[V + 1][V + 1];
        for (int[] arr : edgeM) {
            Arrays.fill(arr, INF);
        }
        for (int i = 0; i <= V; i++) {
            edgeM[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edgeM[node1][node2] = Math.min(edgeM[node1][node2], dist);

        }


        // 경유지
        for (int ch = 1; ch <= V; ch++) {
            // 출발지
            for (int sta = 1; sta <= V; sta++) {
                // 도착지
                for (int end = 1; end <= V; end++) {

                    if (edgeM[sta][ch] != INF && edgeM[ch][end] != INF) {
                        edgeM[sta][end] = Math.min(edgeM[sta][end], edgeM[sta][ch] + edgeM[ch][end]);
                    }
                }
            }
        }

        int minresult = INF*2;
        for (int r = 1; r <= V; r++) {
            for (int c = r; c <= V; c++) {
                if (r == c) continue;
                if (edgeM[r][c] == INF || edgeM[c][r] == INF) {
                    continue;
                }
                minresult = Math.min(edgeM[r][c] + edgeM[c][r], minresult);
            }
        }
        if (minresult == INF*2) {
            bw.write("-1");
        } else {
            bw.write(minresult + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}