import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[3];
        int max = 0;
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int a = arr[0];
        boolean allsame = true;
        for(int i = 1; i < 3; i++){
            if(arr[i] != a){
                allsame = false;
                break;
            }
            a=arr[i];
        }
        if(allsame){
            bw.write((10000+(1000*arr[0]))+"");
        } else {
            if(arr[0]==arr[1]){
                bw.write((1000+(arr[0]*100))+"");
            }  else if (arr[1]==arr[2]){
                bw.write((1000+(arr[1]*100))+"");
            } else if(arr[0]==arr[2]){
                bw.write((1000+(arr[2]*100))+"");
            } else {
                bw.write((100*max)+"");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
