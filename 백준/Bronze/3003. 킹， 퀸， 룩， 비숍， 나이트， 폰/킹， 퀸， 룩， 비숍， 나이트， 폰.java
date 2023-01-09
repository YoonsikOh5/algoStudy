import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int pieces[] = new int[6];

        for(int i = 0; i < 6; i++){
            pieces[i] = Integer.parseInt(st.nextToken());
        }

        int correct[] = {1,1,2,2,2,8};

        for(int i = 0; i < 6; i++){
            bw.write(correct[i] - pieces[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
