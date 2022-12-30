import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

           int year = Integer.parseInt(br.readLine());

           year -= 543;

           bw.write(year+"");

        bw.flush();
        bw.close();
        br.close();

    }

}