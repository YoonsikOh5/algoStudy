import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int d = 0;
        int p = 0;
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            if(c=='D'){
                d++;
            } else if(c=='P'){
                p++;
            }
            if(d>=p+2 ||p>=d+2){
                break;
            }
        }

        bw.write(d+":"+p);
        bw.flush();
        bw.close();
        br.close();

    }


}