import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int idx = str.length();

        for(int i = idx-1; i >= 0; i--){
            bw.write(str.charAt(i));
        }

        bw.flush();
        bw.close();
        br.close();
    }


}
