package day01;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 배열
		 * 타입 배열명[] = new int[개수]
		 * 지역변수는 초기값이 없음. 정해주지 않으면 에러 발생
		 */
		
		String s = new String("가나다라");
		// String은 워낙 자주 사용하는 참조변수여서 일반 자연 변수처럼 사용도 가능하다.
		String s1 = "가나다";
		System.out.println(s);
		System.out.println(s1);
		
		int arr[] = new int[5];
		arr[0] += 1; // 기본값 0이 있어 +1 할 수 있음.
		System.out.println(arr[0]);
		
		// arr 배열에 숫자를 1,2,3,4,5로 채우고 출력
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println("--------------------");
		
		// 5자리 숫자를 입력받아서 각 자리의 합을 출력
		// 입력값 => 12345 => 출력 => 1+2+3+4+5 = ??
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요: ");
		String num = scan.nextLine();
		String[] arr2 = num.split("");
		
		int sum = 0;
		for(int i=0; i<arr2.length; i++) {

			if(i != arr2.length-1) {
				System.out.print(arr2[i] + "+");
			}else {
				System.out.print(arr2[i] + "=");
			}
			
			sum += Integer.parseInt(arr2[i]);
		}
		System.out.println(sum);
		
		sum = 0;
		for(int i=arr2.length-1; i>=0; i--) {

			if(i != 0) {
				System.out.print(arr2[i] + "+");
			}else {
				System.out.print(arr2[0] + "=");
			}
			
			sum += Integer.parseInt(arr2[i]);
		}
		System.out.println(sum);

		scan.close();
		
		
		
	}

}
