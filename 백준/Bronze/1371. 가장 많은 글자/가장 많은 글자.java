import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        int[] arr = new int[27];
        while ((input = br.readLine()) != null) {
            int len = input.length();
            for(int i = 0; i < len; i++){
                char cur = input.charAt(i);
                if(cur != ' '){
                    arr[cur-'a']++;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < 27; i++){
            max = Math.max(arr[i],max);
        }

        for(int i = 0; i < 27; i++){
            if(max == arr[i]){
                bw.write((char)(i+'a')+"");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
