import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];
        int cur = 1;
        int idx = 1;
        for(int i = 1; i <= 1000; i++){
            arr[i] = cur;
            if(cur == idx){
                cur++;
                idx = 1;
            } else {
                idx++;
            }
        }
        int res = 0;
        for(int i = A; i <= B; i++){
            res += arr[i];
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
