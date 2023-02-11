import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mushroomarr = new int[10];
        for(int i = 0; i < 10; i++){
            mushroomarr[i] = Integer.parseInt(br.readLine());
        }
        int cursum = 0;
        int idx = -1;
        for(int i = 0; i < 10; i++){
            cursum += mushroomarr[i];
            if(cursum>=100){
                idx=i;
                break;
            }
        }
        if(idx<=0){
            bw.write(cursum+"");
        } else{
            int before100 = cursum - mushroomarr[idx];
            int after100 = cursum;
            int befabs = Math.abs(100 - before100);
            int aftabs = Math.abs(after100 - 100);
            if(befabs<aftabs){
                bw.write(before100+"");
            } else{
                bw.write(after100+"");
            }
        }


        bw.flush();
        bw.close();
        br.close();

    }


}
