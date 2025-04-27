import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int c2 = 0;
        int ce = 0;
        for(int i = 0; i < N; i++){
            char cur = s.charAt(i);
            if(cur == '2'){
                c2++;
            } else if(cur == 'e'){
                ce++;
            }
        }

        if(c2 > ce){
            bw.write("2");
        } else if(c2 < ce){
            bw.write("e");
        } else if(c2==ce){
            bw.write("yee");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
