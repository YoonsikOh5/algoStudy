import java.io.*;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int isYY = 0;
        int isYX = 0;

        int length = s.length();

        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if(c == 'a'|| c == 'e' || c=='i' || c=='o' || c=='u'){
                isYY++;
                isYX++;
            } else if (c == 'y') {
                isYY++;
            }
        }

        bw.write(isYX+" "+isYY);
        bw.flush();
        bw.close();
        br.close();
    }


}