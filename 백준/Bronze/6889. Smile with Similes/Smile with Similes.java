import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] arr1 = new String[n];
        String[] arr2 = new String[m];
        for(int i = 0; i < n; i++){
            arr1[i] = br.readLine();
        }
        for(int i = 0; i < m; i++){
            arr2[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(arr1[i]+" as "+arr2[j]+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
