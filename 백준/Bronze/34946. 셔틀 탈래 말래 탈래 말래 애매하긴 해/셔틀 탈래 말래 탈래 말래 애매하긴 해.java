import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int ab = a + b;

        boolean isab = false;
        boolean isc = false;
        if(ab <= d){
            isab = true;
        }
        if(c <= d){
            isc = true;
        }

        if(isab && isc){
            bw.write("~.~");
        } else if(!isab && !isc){
            bw.write("T.T");
        } else if(isab && !isc){
            bw.write("Shuttle");
        } else if(!isab && isc){
            bw.write("Walk");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
