import java.io.*;
import java.util.*;

public class Main {

    static int INF = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        while (!line.equals("END")){
            for(int i = line.length()-1; i >= 0; i--){
                bw.write(line.charAt(i));
            }
            bw.write("\n");
            line = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }


}