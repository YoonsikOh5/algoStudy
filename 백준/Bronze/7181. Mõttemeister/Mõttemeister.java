import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int ls = s.length();
        int[] arr = new int[10];
        for(int i = 0; i < ls; i++){
            char cur = s.charAt(i);
            int curc = cur - '0';
            arr[curc] = 1;
        }
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
        int cl = 0;
        int cr = 0;
            String t = br.readLine();
            int len = t.length();
            for(int j = 0; j < len; j++){
                char c = t.charAt(j);
                int cc = c-'0';
                if(arr[cc]==1){
                  cr++;
                }
            }
            int min = Math.min(len, ls);
            for(int j = 0; j < min ; j++){
                char cs = s.charAt(j);
                char ts = t.charAt(j);
                if(cs == ts){
                    cl++;
                }
            }
            bw.write(cr+" "+cl+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
