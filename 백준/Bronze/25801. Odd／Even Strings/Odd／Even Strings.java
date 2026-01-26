import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] arr = new int[28];
        int len = s.length();
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            int j = cur - 'a';
            arr[j]++;
        }
        boolean isOdd = true;
        boolean isEven = true;
        for(int i = 0; i < 28; i++){
            if(arr[i]!=0){
                if(arr[i] % 2 == 0){
                    isOdd = false;
                } else {
                    isEven = false;
                }
            }
        }
        if(isOdd){
            bw.write("1");
        } else if(isEven){
            bw.write("0");
        } else if(!isOdd && !isEven){
            bw.write("0/1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
