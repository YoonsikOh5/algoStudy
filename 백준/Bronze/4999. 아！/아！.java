import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String jaehwan = br.readLine();
		String doctor = br.readLine();
		
		if(jaehwan.length()>=doctor.length()) {
			bw.write("go");
		} else {
			bw.write("no");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}