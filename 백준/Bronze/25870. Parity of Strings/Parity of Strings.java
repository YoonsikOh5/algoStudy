import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = s.length();

        int[] arr = new int[26];
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            int c = cur - 'a';
            arr[c]++;
        }

        boolean isOdd = true;
        boolean isEven = true;

        for(int i = 0; i < 26; i++){
            if(arr[i]!=0 && arr[i]%2==0){
                isOdd = false;
            }
            if(arr[i]%2==1){
                isEven = false;
            }
        }

        if(isEven){
            bw.write("0");
        } else if(isOdd){
            bw.write("1");
        } else {
            bw.write("2");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
