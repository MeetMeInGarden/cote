package bigtech.stack_queue;

import java.util.Scanner;
import java.util.Stack;

// 문제011 스택으로 오름차순 수열 만들기
public class StackQueueMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 첫 째줄 입력
		// 둘 째줄 입력 --> var arr = 배열[첫 째줄 입력 값]
		// Stack 선언
		// Stack +1 씩 push
		// push 하면서 arr 값과 비교
		
		/*
		 * 경우의 수
		 * 증가하는 자연수 = arr 원소 값 -> pop
		 * 증가하는 자연수 > arr 원소 값 -> No
		 * 증가하는 자연수 < arr 원소 값 -> push
		 * 
		 * 4 3 6 8 7 5 2 1
		 * 1 2 5 3 4
		 * */
		
		System.out.println("===== [시작] =====");
		int count = scanner.nextInt();
		int[] arr = new int[count];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		StringBuffer bf = new StringBuffer();
		Stack<Integer> stack = new Stack<>();
		int val = 0;
		stack.push(val); // EmptyStackException 방지, 문제에서 (1이상 n이하의 정수)가 주어진다고 했으므로 이와 무관한 '0'을 넣었다.
		int idx = 0;
		boolean flag = true;
		while(flag) {
			int pekNum = stack.peek();
			int arrNum = arr[idx];
//			
//			System.out.println("---------------------------");
//			System.out.println("pekNum : " + pekNum);
//			System.out.println("arrNum : " + arrNum);
//			System.out.println("---------------------------");
			
			if(pekNum == arrNum) {
				stack.pop();
				bf.append("-\n");
				idx++;
			} else if(pekNum < arrNum) {
				stack.push(++val); // 전위연산자(++val), 후위연산자(val++)에 따라 결과 다르니 주의
				bf.append("+\n");
			} else if(pekNum > arrNum) {
				System.out.println("NO");
				return;		
			}
			
			if(idx == arr.length) {
				flag = false;
			}
		}
		scanner.close();
		
		System.out.println(bf.toString());
//		System.out.println("===== [끝] =====");
	}
}






























