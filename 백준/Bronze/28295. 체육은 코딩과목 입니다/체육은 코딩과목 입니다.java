import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] direct = {'N', 'E', 'S', 'W'};
        int cur = 0;
        for(int i = 1; i <= 10; i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 1){
                cur += 1;
                if(cur > 3){
                    cur = 0;
                }
            } else if (cmd == 2) {
                cur += 2;
                cur %= 4;
            } else if (cmd == 3) {
                cur -= 1;
                if(cur < 0){
                    cur = 3;
                }
            }
        }
        bw.write(direct[cur]+"");
        bw.flush();
        bw.close();
        br.close();
    }


}