package day01;

import java.net.MulticastSocket;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 한줄 주석입니다.
		/*
		 * 여러줄 주석 입니다.
		 * 여러줄로 쓸 수 있습니다.
		 */
		
		System.out.println("Hello Java!!");
		System.out.println("ctrl + space 누르면 자동완성됩니다.");
		
		/* 자료형에 대해 알아봅시다.
		 * let, const를 사용하던 자바스크립트와 달리 값의 타입에 따라 데이터 타입을 지정해 주어야 한다.
		 * ex. int(정수) char(문자1글자) ... 등등
		 * String은 여러개의 문자를 담을 수 있지만 기본 타입은 아니다. 참조형 타입!!
		 * 기본 변수 타입은 8가지 byte, char, short, int, long, float, double, boolean
		 * 변수는 기본적으로 범위(scope)를 가짐 { }를 벗어나면 변수는 사용할 수 없다.
		 */
		
		int num = 10;
		System.out.println(num);
		{
			int num2 = 20;
			System.out.println(num2);
		}
		
		// System.out.println(num2); 범위를 벗어나 Exception 경고가 나타난다.
		// error : 프로그램(코드)적으로 손댈 수 없는 에러
		// Exception : 프로그램적으로 발생할 수 있는 에러(내가 코드를 잘못 짠 경우)
		
		// char : 한글자만 저장 가능하다. ''
		// String : 여러글자 저장 가능. ""
		char c = 'a';
		String s = "bcdef";
		System.out.println(c + s);
		System.out.println((int)c); // a는 아스키코드에서 97
		
		// long, float은 L,F를 접미사로 표현
		// 정수의 기본 자료형 int, 실수의 기본 자료형 double
		long l = 1234567L; // long형의 특징
		System.out.println(l);
		
		float f = 0.1f;
		System.out.println(f); // float형의 특징
		
		// 산술 연산자 : + - * / %
		// 증감 연산자 : ++ --
		// 논리 연산자 : && || !
		// 대입 연산자 : = 
		// 비교 연산자 : == !=
		// 조건선택 연산자 : (조건식)? true : false 연결해서 다중 사용 가능하다.
		
		// + : 산술 연산자이면서 연결 연산자
		// 숫자 + 숫자 : 산술 연산자로 인지
		// 숫자 + 문자 : 연결 연산자로 인지한 다음부터 문자를 연결해줌
		System.out.println(1 + 2); // 3
		System.out.println(1 + 2 + "가나다"); // 3가나다
		System.out.println("가나다" + 1 + 2); // 가나다12 처음에 온 문자열에 의해 뒤의 숫자도 문자로 인식
		
		
		
	}

}
