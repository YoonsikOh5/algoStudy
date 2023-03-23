import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0 ;i < N ;i++){
            sum += Long.parseLong(br.readLine());
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();

    }

}
