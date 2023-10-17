import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[4];
        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(arr[0] < arr[1]){
            boolean isAscending = true;
            for(int i = 1; i < 4;i++){
                if(arr[i-1] >= arr[i]) {
                    isAscending = false;
                    break;
                }
            }
            if(isAscending) {
                bw.write("Fish Rising");
            } else {
                bw.write("No Fish");
            }
        } else if(arr[0]==arr[1]){
            boolean isConstant = true;
            for(int i = 1; i < 4;i++){
                if(arr[i-1] != arr[i]) {
                    isConstant = false;
                    break;
                }
            }
            if(isConstant) {
                bw.write("Fish At Constant Depth");
            } else {
                bw.write("No Fish");
            }
        } else if(arr[0] > arr[1]){
            boolean isDescending = true;
            for(int i = 1; i < 4;i++){
                if(arr[i-1] <= arr[i]) {
                    isDescending = false;
                    break;
                }
            }
            if(isDescending) {
                bw.write("Fish Diving");
            } else {
                bw.write("No Fish");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}