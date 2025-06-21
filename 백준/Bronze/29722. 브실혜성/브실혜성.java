import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String startDate = br.readLine();  // 시작 날짜 (yyyy-mm-dd 형식)
        int N = Integer.parseInt(br.readLine());  // N일 후의 날짜를 구하고 싶을 때 N 값 입력

        String[] sda = startDate.split("-");
        int year = Integer.parseInt(sda[0]);
        int month = Integer.parseInt(sda[1]);
        int day = Integer.parseInt(sda[2]);

        // 한 달을 30일, 1년을 360일로 간주하여 N일 추가 계산
        int yearsToAdd = N / 360;

        year += yearsToAdd;

        int remainingDays = N % 360;

        // 남은 일수에 대해 월과 일 계산
        int monthsToAdd = remainingDays / 30;

        month += monthsToAdd;


        int daysToAdd = remainingDays % 30;

        // 월과 일 추가
        day += daysToAdd;

        // 초과됐을때 넘겨주기
        if(day > 30){
            month++;
            day %= 30;
        }
        if(month > 12){
            year++;
            month %= 12;
        }

        String formattedDate = String.format("%04d-%02d-%02d", year, month, day);

        // 결과 출력
        bw.write(formattedDate+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
