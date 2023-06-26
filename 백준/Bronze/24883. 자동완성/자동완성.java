import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String str = br.readLine();

        if(str.charAt(0)=='N'||str.charAt(0)=='n'){
            bw.write("Naver D2");
        } else {
            bw.write("Naver Whale");
        }


        bw.flush();
        bw.close();
        br.close();
    }


}