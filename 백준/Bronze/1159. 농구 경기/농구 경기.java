import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());


        int[] arr = new int[27];
        for(int i = 1; i <= K; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            int cur = c - 'a';
            arr[cur]++;
        }

        boolean ist = false;
        for(int i = 0; i < 27; i++){
            if(arr[i] >= 5){
                ist = true;
                bw.write((char)(i+'a')+"");
            }
        }

        if(!ist){
            bw.write("PREDAJA");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
