import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int len = str.length();

        int result = -1;

        char start = str.charAt(0);

        boolean allsame = true;
        for (int i = 0; i < len / 2; i++) {
            char leftc = str.charAt(i);
            char rightc = str.charAt(len - 1 - i);
            if (leftc != rightc) {
                result = len;
            }
            if (allsame) {
                if (leftc != start) {
                    allsame = false;
                }
                if (rightc != start) {
                    allsame = false;
                }
            }
        }

        if(start != str.charAt(len/2)){
            allsame = false;
        }

        if(!allsame && result == -1){
            result = len-1;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}
