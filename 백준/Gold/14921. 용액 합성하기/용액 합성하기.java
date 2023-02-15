import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lp = 0;
        int rp = N-1;
        int result = Integer.MAX_VALUE;
        outloop : for(int i = 0; i < N; i++){
            lp = i;
            if(lp>=rp){
                break;
            }
            for(int j = N-1; j >=0; j--){
                rp = j;
                if(lp>=rp){
                    break outloop;
                }
                int cur = arr[lp] + arr[rp];
                if(Math.abs(result)> Math.abs(cur)){
                    result = cur;
                    if(result==0){
                        break outloop;
                    }
                }
                if(cur<0){
                    break;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }


}
