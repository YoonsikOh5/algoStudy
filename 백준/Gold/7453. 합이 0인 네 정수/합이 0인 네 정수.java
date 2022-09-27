import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
	
	
	
	public class Main {
	
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			
			int arrA[] = new int[n];
			int arrB[] = new int[n];
			int arrC[] = new int[n];
			int arrD[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arrA[i] = Integer.parseInt(st.nextToken());
				arrB[i] = Integer.parseInt(st.nextToken());
				arrC[i] = Integer.parseInt(st.nextToken());
				arrD[i] = Integer.parseInt(st.nextToken());
			}
			
			int arrAB[] = new int[n*n];
			int arrCD[] = new int[n*n];
			int idx = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int cur = arrA[i] + arrB[j];
					arrAB[idx] = cur;
					cur = arrC[i] + arrD[j];
					arrCD[idx++] = cur;
				}				
			}
			
			long count = 0;

			Arrays.sort(arrAB);
			Arrays.sort(arrCD);
			
			int j = arrCD.length-1;
			for(int i = 0, size = arrAB.length; i < size; i++) {
				
				int sumabcd = arrAB[i]+arrCD[j];
				while(sumabcd!=0 && j>0 && i<size-1) {
					if(sumabcd > 0) {
						j--;						
					} else if (sumabcd < 0) {
						i++;
					}
					sumabcd = arrAB[i]+arrCD[j];
				}
				
				if(sumabcd==0) {
					long abcount = 1;
					long cdcount = 1;
					while(i<size-1 && arrAB[i]==arrAB[i+1]) {
						abcount++;
						i++;
					}
					while(j>0 && arrCD[j]==arrCD[j-1]) {
						cdcount++;
						j--;
					}
					count += abcount*cdcount;
				}
				
			}
			
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(count+"");
			bw.flush();
			bw.close();
			br.close();
			
			
		}
	
	}
