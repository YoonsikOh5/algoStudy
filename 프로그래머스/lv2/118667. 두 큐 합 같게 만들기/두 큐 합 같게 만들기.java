import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int len1 = queue1.length;
        int len2 = queue2.length;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        for (int i = 0; i < len1; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        long sum2 = 0;
        for (int i = 0; i < len2; i++) {
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        long totalsum = sum1 + sum2;

        if (totalsum % 2 == 1) {
           return -1;
        }

        int idx = 0;
        while(idx <= 1000000){
            if(sum1==sum2){
               return idx;
            }
            if(sum1 >= sum2){
                Integer polled = q1.poll();
                sum1 -= polled;
                sum2 += polled;
                q2.offer(polled);
            } else {
                Integer polled = q2.poll();
                sum1 += polled;
                sum2 -= polled;
                q1.offer(polled);
            }
            idx++;
        }
       return -1;
    }
}