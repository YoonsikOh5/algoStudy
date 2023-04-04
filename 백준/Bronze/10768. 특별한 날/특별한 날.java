import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if(month==2&&day==18){
            bw.write("Special");
        } else if(month>=3 ||(month>=2 && day>18)){
            bw.write("After");
        } else {
            bw.write("Before");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}