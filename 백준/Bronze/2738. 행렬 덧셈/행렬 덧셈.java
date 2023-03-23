import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                matrix[r][c] += Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                bw.write(matrix[r][c] + " ");
            }
                bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
