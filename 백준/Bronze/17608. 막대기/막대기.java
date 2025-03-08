import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> sta = new Stack<>();

        for(int i = 0; i < N; i++){
            sta.push(Integer.parseInt(br.readLine()));
        }
        int max = 0;
        int res = 0;
        while (sta.size()>0){
            Integer pop = sta.pop();
            if(pop > max){
                max = pop;
                res++;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
