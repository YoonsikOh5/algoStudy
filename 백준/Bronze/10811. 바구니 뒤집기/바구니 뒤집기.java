import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int n2 = j1 - i1;
            int[] arr2 = new int[n2+1];
            int idx = 0;
            for(int j = i1; j <= j1; j++){
                arr2[idx++] = arr[j];
            }
            idx = 0;
            for(int j = j1; j >= i1; j--){
                arr[j] = arr2[idx++];
            }
        }
        for(int i = 1; i <= N; i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
