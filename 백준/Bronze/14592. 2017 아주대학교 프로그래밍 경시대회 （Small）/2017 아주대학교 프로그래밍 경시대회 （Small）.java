import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int res = 1;
        int amax = 0;
        int bmin = Integer.MAX_VALUE;
        int cmin = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(amax < a){
                amax = a;
                bmin = b;
                cmin = c;
                res = i;
            } else {
                if(amax == a){
                    if(bmin > b){
                        bmin = b;
                        cmin = c;
                        res = i;
                    } else {
                        if(bmin == b){
                            if(cmin > c){
                                cmin = c;
                                res = i;
                            }
                        }
                    }
                }
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
