import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int res = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int first = arr[0];

        Arrays.sort(arr);

        if(arr[0]==first){
            bw.write("ez");
        } else if(arr[N-1]==first){
            bw.write("hard");
        } else {
            bw.write("?");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
