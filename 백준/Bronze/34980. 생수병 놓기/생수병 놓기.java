import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String bf = br.readLine();
        String af = br.readLine();

        boolean isT = true;
        int bcnt = 0;
        int acnt = 0;

        for(int i = 0; i < N; i++){
            char bc = bf.charAt(i);
            char ac = af.charAt(i);
            if(bc != ac){
                isT = false;
            }
            if(bc == 'w'){
                bcnt++;
            }
            if(ac == 'w'){
                acnt++;
            }
        }

        if(acnt < bcnt){
            bw.write("Oryang");
        } else if(acnt > bcnt){
            bw.write("Manners maketh man");
        } else if(acnt == bcnt){
            if(isT){
                bw.write("Good");
            } else {
                bw.write("Its fine");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
