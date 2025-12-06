import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String W = br.readLine();
        String S = br.readLine();

        char[] alp = new char[26];
        char[] arr = new char[26];
        int len = W.length();
        int idx = 0;
        for(int i = 0; i < len; i++){
            char cur = W.charAt(i);
            int ci = cur - 'A';
            if(alp[ci]==0){
                alp[ci] = 1;
                arr[idx] = cur;
                idx++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(alp[i]==0){
                char cc = (char) (i + 'A');
                arr[idx] = cc;
                idx++;
            }
        }

        int slen = S.length();
        for(int i = 0; i < slen; i++){
            char c = S.charAt(i);
            int cs = c - 'A';
            bw.write(arr[cs]+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
