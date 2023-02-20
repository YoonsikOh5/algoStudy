import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];

        int sum = 0;

        boolean eq = true;

        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if(arr[i]!=60){
                eq = false;
            }
        }

        if(eq){
            bw.write("Equilateral");
        } else{
            if(sum==180){
                int a = arr[0];
                int b = arr[1];
                int c = arr[2];
                if(a==b||a==c||b==c){
                    bw.write("Isosceles");
                } else{
                    bw.write("Scalene");
                }
            } else{
                bw.write("Error");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
