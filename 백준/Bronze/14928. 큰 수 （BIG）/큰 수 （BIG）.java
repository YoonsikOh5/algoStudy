import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String bignum = br.readLine();
        long temp = 0;
        for (int i = 0; i < bignum.length(); i++) {
            temp = (temp * 10 + (bignum.charAt(i) - '0')) % 20000303;
        }

        bw.write(temp + "");
        bw.flush();
        bw.close();
        br.close();

    }

}
