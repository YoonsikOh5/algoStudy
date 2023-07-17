import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String palinTarget = br.readLine();

            int left = 0;
            int right = palinTarget.length() - 1;
            int difCount = 0;
            int isPalin = 0;
            int firstdifleft = 0;
            int firstdifright = 0;
            while (left < right) {
                if (palinTarget.charAt(left) == palinTarget.charAt(right)) {
                    left++;
                    right--;
                } else {
                    if(difCount==0){
                        // 왼쪽부터 한칸 더
                        firstdifleft = left;
                        firstdifright = right;
                        isPalin=1;
                        left++;
                        difCount++;
                    } else if(difCount==1){
                        left=firstdifleft;
                        right=firstdifright;

                        right--;
                        difCount++;
                    } else if(difCount==2){
                        isPalin = 2;
                        break;
                    }
                }
            }

            bw.write(isPalin+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


}