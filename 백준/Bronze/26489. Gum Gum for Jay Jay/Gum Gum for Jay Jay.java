import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int count = 0;
        while(s != null){
            count++;
            s = br.readLine();
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }

}