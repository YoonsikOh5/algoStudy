import java.io.*;
import java.util.*;

public class Main {


    static class Cube {

        char[][] upSide;
        char[][] downSide;
        char[][] frontSide;
        char[][] backSide;
        char[][] leftSide;
        char[][] rightSide;

        public Cube() {
            this.upSide = new char[3][3];
            this.downSide = new char[3][3];
            this.frontSide = new char[3][3];
            this.backSide = new char[3][3];
            this.leftSide = new char[3][3];
            this.rightSide = new char[3][3];

            for (char[] chars : this.upSide) {
                Arrays.fill(chars, 'w');
            }
            for (char[] chars : this.downSide) {
                Arrays.fill(chars, 'y');
            }
            for (char[] chars : this.frontSide) {
                Arrays.fill(chars, 'r');
            }
            for (char[] chars : this.backSide) {
                Arrays.fill(chars, 'o');
            }
            for (char[] chars : this.leftSide) {
                Arrays.fill(chars, 'g');
            }
            for (char[] chars : this.rightSide) {
                Arrays.fill(chars, 'b');
            }
        }

        public void rotate(char side, char direction) {
            switch (side) {
                case 'U':
                    if (direction == '+') {
                        upSide = rotateClockSide(upSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = frontSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = leftSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = backSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = rightSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[0][c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[0][c] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[0][c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[0][c] = temp3[c];
                        }
                    } else if (direction == '-') {
                        upSide = rotateReverseClockSide(upSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = frontSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = rightSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = backSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = leftSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[0][c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[0][c] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[0][c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[0][c] = temp3[c];
                        }
                    }
                    break;
                case 'D':
                    if (direction == '+') {
                        downSide = rotateReverseClockSide(downSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = frontSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = leftSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = backSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = rightSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[2][c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[2][c] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[2][c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[2][c] = temp[c];
                        }
                    } else if (direction == '-') {
                        downSide = rotateClockSide(downSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = frontSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = rightSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = backSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = leftSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[2][c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[2][c] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[2][c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[2][c] = temp[c];
                        }
                    }
                    break;
                case 'F':
                    if (direction == '+') {
                        frontSide = rotateClockSide(frontSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = rightSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = leftSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[2][2-c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[c][0] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[2][2-c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[c][2] = temp3[c];
                        }
                    } else if (direction == '-') {
                        frontSide = rotateReverseClockSide(frontSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = rightSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[2][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = leftSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[2][c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[2-c][0] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[2][c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[2-c][2] = temp[c];
                        }
                    }
                    break;
                case 'B':
                    if (direction == '+') {
                        backSide = rotateClockSide(backSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = rightSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = leftSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[2-c][0] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[0][c] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[2-c][2] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[0][c] = temp2[c];
                        }
                    } else if (direction == '-') {
                        backSide = rotateReverseClockSide(backSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = rightSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[0][c];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = leftSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            leftSide[c][0] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[0][2-c] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            rightSide[c][2] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[0][2-c] = temp4[c];
                        }
                    }
                    break;
                case 'L':
                    if (direction == '+') {
                        leftSide = rotateClockSide(leftSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = frontSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = backSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[c][0] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[2-c][0] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[c][2] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[2-c][0] = temp4[c];
                        }
                    } else if (direction == '-') {
                        leftSide = rotateReverseClockSide(leftSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = frontSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = backSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[2-c][0] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[c][0] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[2-c][2] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[c][0] = temp2[c];
                        }
                    }
                    break;
                case 'R':
                    if (direction == '+') {
                        rightSide = rotateClockSide(rightSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = frontSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = backSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[c][2] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[2-c][0] = temp[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[c][2] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[2-c][2] = temp3[c];
                        }
                    } else if (direction == '-') {
                        rightSide = rotateReverseClockSide(rightSide);
                        char temp[] = new char[3];
                        char temp2[] = new char[3];
                        char temp3[] = new char[3];
                        char temp4[] = new char[3];
                        for (int c = 0; c < 3; c++) {
                            temp[c] = upSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp2[c] = frontSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp3[c] = downSide[c][2];
                        }
                        for (int c = 0; c < 3; c++) {
                            temp4[c] = backSide[c][0];
                        }
                        for (int c = 0; c < 3; c++) {
                            upSide[2-c][2] = temp4[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            backSide[c][0] = temp3[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            downSide[2-c][2] = temp2[c];
                        }
                        for (int c = 0; c < 3; c++) {
                            frontSide[c][2] = temp[c];
                        }
                    }
                    break;
            }
        }

        private char[][] rotateClockSide(char[][] side) {
            char[][] newSide = new char[3][3];
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    newSide[c][2 - r] = side[r][c];
                }
            }
            return newSide;
        }

        private char[][] rotateReverseClockSide(char[][] side) {
            char[][] newSide = new char[3][3];
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    newSide[2 - c][r] = side[r][c];
                }
            }
            return newSide;
        }

        @Override
        public String toString() {
            return upSide[0][0] +""+ upSide[0][1] +""+ upSide[0][2] +""+ "\n" + upSide[1][0] + upSide[1][1] + upSide[1][2] + "\n" + upSide[2][0] + upSide[2][1] + upSide[2][2] + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Cube cube = new Cube();
            for (int r = 1; r <= n; r++) {
                String cmd = st.nextToken();
                char side = cmd.charAt(0);
                char direction = cmd.charAt(1);
                cube.rotate(side, direction);
            }
            bw.write(cube.toString());
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
