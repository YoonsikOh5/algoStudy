import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            if(cur==136){
                sum +=1000;
            } else if(cur == 142){
                sum += 5000;
            } else if(cur == 148){
                sum += 10000;
            } else if(cur == 154){
                sum += 50000;
            }
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }


}