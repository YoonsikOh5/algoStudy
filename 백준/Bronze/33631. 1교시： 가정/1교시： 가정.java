import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] carr = new int[4];
        int[] parr = new int[4];

        for (int i = 0; i < 4; i++) {
            int cur = Integer.parseInt(st.nextToken());
            carr[i] = cur;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            int cur = Integer.parseInt(st.nextToken());
            parr[i] = cur;
        }

        int N = Integer.parseInt(br.readLine());

        int cookie = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());

            if(cmd == 1){
                boolean isC = true;
                for(int j = 0 ;j < 4; j++){
                    if(carr[j] < parr[j]*cur){
                        isC = false;
                    }
                }
                if(isC){
                    for(int j = 0 ;j < 4; j++){
                        carr[j] -= parr[j]*cur;
                    }
                    cookie += cur;
                    bw.write(cookie+"\n");
                } else {
                    bw.write("Hello, siumii\n");
                }

            } else if(cmd == 2){
                carr[cmd-2] += cur;
                bw.write(carr[cmd-2]+"\n");
            } else if(cmd == 3){
                carr[cmd-2] += cur;
                bw.write(carr[cmd-2]+"\n");
            } else if(cmd == 4){
                carr[cmd-2] += cur;
                bw.write(carr[cmd-2]+"\n");
            } else if(cmd == 5){
                carr[cmd-2] += cur;
                bw.write(carr[cmd-2]+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
