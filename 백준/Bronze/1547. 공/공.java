import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int curball = 1;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cup1 = Integer.parseInt(st.nextToken());
            int cup2 = Integer.parseInt(st.nextToken());
            if(cup1 == curball){
                curball = cup2;
            } else if(cup2 == curball){
                curball = cup1;
            }
        }


        bw.write(curball+"");
        bw.flush();
        bw.close();
        br.close();

    }


}
