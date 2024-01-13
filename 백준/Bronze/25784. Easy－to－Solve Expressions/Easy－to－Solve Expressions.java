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

        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        Integer min = pq.poll();
        Integer mid = pq.poll();
        Integer max = pq.poll();

        if(max==(mid+min)){
            bw.write("1");
        } else if(max==(mid*min)){
            bw.write("2");
        } else {
            bw.write("3");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}