import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean isA = false;
        boolean isB = false;
        boolean isP = true;
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(!(cur >= A && cur <= B)){
                isP = false;
                break;
            }
            if(cur == A){
                isA = true;
            }
            if(cur == B){
                isB = true;
            }
        }

        if(!isA && !isB){
            isP = false;
        }
        if(!isP){
            bw.write("-1");
        } else if(!isA){
            bw.write(A+"");
        } else if(!isB){
            bw.write(B+"");
        } else {
            for(int i = A; i <= B; i++){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
