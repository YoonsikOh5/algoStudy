import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int sN;
    static Student[] sarr;
    static Student[][] sMatrix;

    static class Student {

        int num;

        HashSet<Integer> hs;

        public Student(int num, int s1, int s2, int s3, int s4) {
            this.num = num;
            this.hs = new HashSet<>();
            this.hs.add(s1);
            this.hs.add(s2);
            this.hs.add(s3);
            this.hs.add(s4);
        }

        boolean isLike(int num) {
            if (this.hs.contains(num)) {
                return true;
            } else {
                return false;
            }
        }

    }

    static class Seat {
        int likenum;
        int emptynum;

        int r;
        int c;

        public Seat(int r, int c) {
            this.r = r;
            this.c = c;
            likenum = 0;
            emptynum = 0;
        }
    }

    // 상하좌우
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        sN = N * N;
        sarr = new Student[sN];

        for (int i = 0; i < sN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            int n4 = Integer.parseInt(st.nextToken());
            sarr[i] = new Student(num, n1, n2, n3, n4);
        }

        sMatrix = new Student[N][N];

        for (int i = 0; i < sN; i++) {
            Student student = sarr[i];
            PriorityQueue<Seat> pq = new PriorityQueue<>(new Comparator<Seat>() {
                @Override
                public int compare(Seat o1, Seat o2) {
                    if (o1.likenum == o2.likenum) {
                        if (o1.emptynum == o2.emptynum) {
                            if (o1.r == o2.r) {
                                return o1.c - o2.c;
                            }
                            return o1.r - o2.r;
                        }
                        return o2.emptynum - o1.emptynum;
                    }
                    return o2.likenum - o1.likenum;
                }
            });
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (sMatrix[r][c] != null) {
                        continue;
                    }
                    Seat seat = new Seat(r, c);
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            if (sMatrix[nr][nc] == null) {
                                seat.emptynum++;
                            } else {
                                if (student.isLike(sMatrix[nr][nc].num)) {
                                    seat.likenum++;
                                }
                            }
                        }
                    }
                    pq.offer(seat);
                } // for c
            }// for r
            Seat poll = pq.poll();
            sMatrix[poll.r][poll.c] = student;
        }

//        bw.write("얍");
//        for(int r = 0; r < N; r++){
//            for(int c= 0; c < N; c++){
//                bw.write(sMatrix[r][c].num+" ");
//            }
//                bw.write("\n");
//        }
//        bw.write("얍끝");

        long resultsum = 0;


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                Student student = sMatrix[r][c];
                int likenum = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        if (student.isLike(sMatrix[nr][nc].num)) {
                            likenum++;
                        }
                    }
                }
                switch (likenum) {
                    case 0:
                        resultsum += 0;
                        break;
                    case 1:
                        resultsum += 1;
                        break;
                    case 2:
                        resultsum += 10;
                        break;
                    case 3:
                        resultsum += 100;
                        break;
                    case 4:
                        resultsum += 1000;
                        break;
                }
            } // for c
        }// for r

        bw.write(resultsum+"");
        bw.flush();
        bw.close();
        br.close();

    }

}

