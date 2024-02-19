import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Character> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            q.offer(st.nextToken().charAt(0));
        }
        int cnt = 0;
        char cur = br.readLine().charAt(0);
        while (q.size()>0){
            Character poll = q.poll();
            if(cur==poll) cnt++;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}