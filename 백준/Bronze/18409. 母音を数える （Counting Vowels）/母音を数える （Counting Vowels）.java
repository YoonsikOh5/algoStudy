import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            char c = s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                cnt++;
            };
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }


}