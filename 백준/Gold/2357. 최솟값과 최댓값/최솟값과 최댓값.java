import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class SegmentTree {
        int level = 0;
        int length = 0;
        long[] inputList;
        int inputListLength;
        int inputStartIndex = 0;
        int inputEndIndex = 0;
        int treeIndex = 1;
        String calculationMethod;
        long[] resultList;

        // 생성자
        public SegmentTree(long[] inputList, String calculationMethod) {
            // 어떤 계산을 할지
        	this.calculationMethod = calculationMethod;
        	// inputList의 길이
        	this.inputListLength = inputList.length;
        	// 인풋 리스트의 마지막 인덱스
        	this.inputEndIndex = this.inputListLength - 1;
        	// 인풋 리스트 생성
        	this.inputList = new long[this.inputListLength];
        	
        	// 인풋 리스트 값 깊은 복사
            for(int i = 0; i < this.inputListLength; i++) {
                this.inputList[i] = inputList[i];
            }

            // 이게 조금 어려움
            // resultList의 level과 length를 구하는 건데 일단은 그러려니
            this.level = (int) Math.ceil(Math.log(this.inputListLength) / Math.log(2)) + 1;
            this.length = (int) Math.pow(2, this.level);
            this.resultList = new long[this.length];

            // public long make(int inputStartIndex, int inputEndIndex, int treeIndex) {
            // input의 스타트는 0 마지막은 length-1, treeIndex는 1부터 시작
            this.make(0, this.inputListLength-1, 1);
        }

        public long gcd(long leftResult, long rightResult) {
            if (rightResult == 0) {
                return leftResult;
            }

            return this.gcd(rightResult, leftResult % rightResult);
        }

        public long method(long leftResult, long rightResult) {
            switch (this.calculationMethod) {
                case "sum":
                    return leftResult + rightResult;
                case "max":
                    return Math.max(leftResult, rightResult);
                case "min":
                	return Math.min(leftResult, rightResult);
                case "gcd":
                    return this.gcd(leftResult, rightResult);
                case "mul":
                	return (leftResult * rightResult) % 1000000007;
            }

            return leftResult + rightResult;
        }

        public long updateProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int updateIndex, long updateValue) {
        	if ((updateIndex < inputStartIndex) || (updateIndex > inputEndIndex)) {
                return this.resultList[treeIndex];
            }

            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = updateValue;
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;
            long leftResult = this.updateProcess(inputStartIndex, inputMidIndex, treeIndex * 2, updateIndex, updateValue);
            long rightResult = this.updateProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, updateIndex, updateValue);

            this.resultList[treeIndex] = this.method(leftResult, rightResult);

            return this.resultList[treeIndex];
        }

        public void update(int updateIndex, long updateValue) {
            this.treeIndex = 1;
            this.inputList[updateIndex] = updateValue;

            this.updateProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, updateIndex, updateValue);
        }

        public long getRangeProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int rangeStartIndex, int rangeEndIndex) {
        	// 완전하게 벗어난 위치는 무효
            if ((inputEndIndex < rangeStartIndex) || (inputStartIndex > rangeEndIndex)) {
            	if(this.calculationMethod=="mul") {
            		return 1;
            	}
            	if(this.calculationMethod=="min") {
            		return Long.MAX_VALUE;
            	}
                return 0;
            }

            // 구간에 완전히 들어감.(리프, 아닐수도)
            // 그냥 값 가져오고 밑에 내려가지마
            if ((inputStartIndex >= rangeStartIndex) && (inputEndIndex <= rangeEndIndex)) {
                return this.resultList[treeIndex];
            }
            
            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            long leftResult = this.getRangeProcess(inputStartIndex, inputMidIndex, treeIndex * 2, rangeStartIndex, rangeEndIndex);
            long rightResult = this.getRangeProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, rangeStartIndex, rangeEndIndex);

            return this.method(leftResult, rightResult);
        }

        public long getRange(int rangeStartIndex, int rangeEndIndex) {
            return this.getRangeProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, rangeStartIndex, rangeEndIndex);
        }

        public long make(int inputStartIndex, int inputEndIndex, int treeIndex) {
          
        	// 1. 리프노드라면 ti에 현재 값을 채우고 값을 가지고 올라온다
        	if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = this.inputList[inputStartIndex];
                return this.resultList[treeIndex];
            }
        	
        	// 2. 다음 왼/오를 구분하기 위해 중간값을 찾는다
            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;
            
            // 3. 왼쪽값과 오른쪽 값을 가져온다.
            long left_result = this.make(inputStartIndex, inputMidIndex, treeIndex * 2);
            long right_result = this.make(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1);

            // 4. 두 값의 연산결과를 현위치에 저장하고
            this.resultList[treeIndex] = this.method(left_result, right_result);
            
            // 5. 해당 값을 리턴
            return this.resultList[treeIndex];
        }

    }

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
//    	int K = Integer.parseInt(st.nextToken());
    	
    	long[] numberList = new long[N];
    	
    	for(int i = 0; i < N; i++) {
    		numberList[i] = Long.parseLong(br.readLine());
    	}

        SegmentTree segmentTreeMax = new SegmentTree(numberList, "max");
        SegmentTree segmentTreeMin = new SegmentTree(numberList, "min");
        
        
        for(int i = 1, size = M; i <= size; i++) {
        	st = new StringTokenizer(br.readLine());
        		int starti = Integer.parseInt(st.nextToken());
        		int endi = Integer.parseInt(st.nextToken());
        		bw.write(segmentTreeMin.getRange(starti-1,endi-1)+" ");
        		bw.write(segmentTreeMax.getRange(starti-1,endi-1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
