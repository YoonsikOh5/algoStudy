import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char bef = str.charAt(0);
            bw.write(bef+"");
            for(int j = 1; j < str.length(); j++){
                if(bef==str.charAt(j)){
                    continue;
                } else{
                    bef = str.charAt(j);
                    bw.write(bef+"");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}