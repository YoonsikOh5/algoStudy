import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        int[] arr1 = {200,210,220,225,230,235};
        int[] arr2 = {210,220,225,230,235,245};
        int[] arr3 = {220,225,230,235,245,250};

        int[] arr11 = {260,265,270,275,280,285,290};
        int[] arr22 = {265,270,275,280,285,290,295};
        int[] arr33 = {270,275,280,285,290,295,300};

        for(int i = 0; i < 6; i++){
            int cur = 0;
            if(arr1[i] <= L){
                cur = 500;
            }
            if(arr2[i] <= L){
                cur -= 200;
            }
            if(arr3[i] <= L){
                cur -= 200;
            }
            bw.write(cur+" ");
        }
        bw.write("\n");

        for(int i = 0; i < 7; i++){
            int cur = 0;
            if(arr11[i] <= L){
                cur = 500;
            }
            if(arr22[i] <= L){
                cur -= 200;
            }
            if(arr33[i] <= L){
                cur -= 200;
            }
            bw.write(cur+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
