import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        arr[1] = 1;
        arr[2] = 0;
        arr[3] = 0;
        arr[4] = 2;

        String s = br.readLine();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (cur == 'A') {
                int tmp = arr[2];
                arr[2] = arr[1];
                arr[1] = tmp;
            } else if (cur == 'B') {
                int tmp = arr[3];
                arr[3] = arr[1];
                arr[1] = tmp;
            } else if (cur == 'C') {
                int tmp = arr[4];
                arr[4] = arr[1];
                arr[1] = tmp;
            } else if (cur == 'D') {
                int tmp = arr[2];
                arr[2] = arr[3];
                arr[3] = tmp;
            } else if (cur == 'E') {
                int tmp = arr[4];
                arr[4] = arr[2];
                arr[2] = tmp;
            } else if (cur == 'F') {
                int tmp = arr[4];
                arr[4] = arr[3];
                arr[3] = tmp;
            }
        }
        for(int i= 1; i <= 4; i++){
            if(arr[i]==1){
                bw.write(i+"\n");
            }
        }
        for(int i= 1; i <= 4; i++){
            if(arr[i]==2){
                bw.write(i+"");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
