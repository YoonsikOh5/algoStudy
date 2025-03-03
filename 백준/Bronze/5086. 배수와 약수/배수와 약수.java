import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(a == 0 && b == 0) {
        		break;
        	}
        	
        	boolean isf = false;
        	boolean ism = false;
        	if(b % a == 0) {
        		isf = true;
        		bw.write("factor\n");
        	}
        	if(a % b == 0) {
        		ism = true;
        		bw.write("multiple\n");
        	}
        	if(!isf && !ism) {
        		bw.write("neither\n");        		
        	}
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
