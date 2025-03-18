import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1;i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String o = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            boolean isT = true;
            if(o.equals("+")){
                if(a + b != c){
                    isT = false;
                }
            } else if(o.equals("-")){
                if(a - b != c){
                    isT = false;
                }
            }
            if(isT){
                bw.write("Case "+i+": YES\n");
            } else {
                bw.write("Case "+i+": NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
