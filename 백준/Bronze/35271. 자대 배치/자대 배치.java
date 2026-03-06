import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] capacity = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            capacity[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            if (capacity[first] > 0) {
                capacity[first]--;
                result[i] = first;
            } else if (capacity[second] > 0) {
                capacity[second]--;
                result[i] = second;
            } else if (capacity[third] > 0) {
                capacity[third]--;
                result[i] = third;
            } else {
                result[i] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(result[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
