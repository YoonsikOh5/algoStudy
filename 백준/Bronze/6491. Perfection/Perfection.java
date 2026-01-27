import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true){
            if(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            int cur = Integer.parseInt(st.nextToken());
            if(cur==0) {
                break;
            }

            int sum = 0;
            for(int i = 1; i < cur; i++){
                if(cur % i == 0){
                    sum += i;
                }
            }
            if(sum == cur){
                bw.write(cur+" PERFECT\n");
            } else if(sum < cur){
                bw.write(cur+" DEFICIENT\n");
            } else if(sum > cur){
                bw.write(cur+" ABUNDANT\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
