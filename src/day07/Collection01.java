package day07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Collection01 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크 : 표준화된 방식의 자료구조
		 * List, Set, Map => 인터페이스 반드시 구현 클래스로 객체를 생성
		 * 데이터를 묶어서 관리할 때 사용
		 * 주로 배열 대신 사용
		 * 
		 * List(배열과 동일)
		 * - 값을 하나씩 저장
		 * - index : 순서를 보장
		 * - 중복 허용
		 * - 배열 대신에 가장 많이 사용하는 구조
		 * 
		 * Set
		 * - 값을 하나씩 저장
		 * - index가 없음 > 순서를 보장하지 않음
		 * - 중복이 허용되지 않음 (같은 값이 입력되면 덮어씀 > 같은값ㅇㅇ)
		 * 
		 * Map
		 * - 값을 key/value 쌍으로 저장
		 * - index는 없고, key가 구분자 역할을 함 > key는 중복 불가능
		 * - key는 중복 불가능 / value는 중복 가능
		 * - key가 중복되면 value는 덮어써짐 
		 * - 2개의 값이 하나의 자료로 묶어야 할 때 사용
		 * - 아이디/패스워드 or 제품명/가격 or 학생명/점수
		 * 
		 * 배열은 기본자료형이 가능함
		 * int arr[], double arr[], String arr[], Student arr[] 전부 가능함
		 * 
		 * Collection은 기본자료형은 불가능함 / 클래스 자료형만 가능
		 * 래퍼 클래스(Wrapper Class) : 기본타입 자료형을 클래스 타입으로 변환한 클래스
		 * 기본 자료형 (Boxing) > 클래스 자료형으로
		 * 클래스 자료형을 (UnBoxing) 기본자료형으로 
		 * 
		 * 기본자료형 > 래퍼클래스
		 * int > Integer
		 * char > Character
		 * byte > Byte
		 * short > Short
		 * long > Long
		 * float > Float
		 * double > Double
		 * boolean > Boolean
		 * 
		 * Collection에서 클래스를 지정하지 않으면 Object가 자동으로 설정
		 * 
		 * 리스트 생성
		 * List<className> 객체명 = new 구현클래스<className>();
		 * List<Integer> list = new ArrayList<Integer>();
		 * List의 구현클래스 => ArrayList, LinkedList
		 * 
		 * ArrayList : 검색시 유리(배열과 유사한 형태)
		 * - 미리 길이를 지정하지 않음, 추가되면 늘어나고 삭제되면 줄어듬
		 * - 추가, 삭제가 쉽다. 검색이 쉽다.
		 * 
		 * LinkedList : 추가나 삭제가 많을 경우 유리함
		 * - 중간에 값을 끼워넣거나 빼는게 쉬움
		 * - 검색이 느림
		 * 
		 */
		
		int num = 10;
//		Integer boxNum = new Integer(num);
		Integer boxNum = 20; //자동박싱
		int a = boxNum; //자동언박싱
//		System.out.println(boxNum);
//		System.out.println(a);
//		
		//클래스.parse+기본타입명 : 형변환 가능.
		String str = "10"; // String > int
		int i = Integer.parseInt(str);
		
		List<Integer> list = new ArrayList<Integer>(); //부모를 기준으로 생성
		ArrayList<Integer> list2 = new ArrayList<Integer>(); //자식 기준으로 생성
		List list3 = new ArrayList(); //Object로 새성
		ArrayList<Integer> list4 = new ArrayList<>(); //생략가능 그냥 list도 생략가능 : 구현체 클래스 생략 가능
		
		List<Integer> linkedList = new LinkedList<>(); //LinkedList 생성
		
		/* List Method
		 * - add() : 요소를 추가
		 * - get() : 
		 * 
		 */
		
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		// get() : index 번지의 요소 가져오기 
		System.out.println(list.get(0));
		
		// set(index, value) : index 번지의 값을 value로 변경
		System.out.println(list.set(0, 10));
		System.out.println(list);
		
		// size() : list의 개수
		for(int j=0; j<list.size(); j++) {
			System.out.println(list.get(j));
		}
		
		// 향상된 for문에서 int/Integer 둘 다 가능
		for(int tmp1 : list) {
			System.out.print(tmp1 + " ");
		}
		System.out.println();
		for(Integer tmp1 : list) {
			System.out.print(tmp1 + " ");
		}
		System.out.println();
		System.out.println("--list.size()--");
		System.out.println(list.size());
		
		// 문자열을 담는 리스트 생성
		// 문자열 5개 추가
		List<String> listStr = new ArrayList<String>();
		listStr.add("가");
		listStr.add("나");
		listStr.add("다");
		listStr.add("라");
		listStr.add("마");
	
		for(int j=0; j<listStr.size(); j++) {
			System.out.print(listStr.get(j) + " ");
		}
		System.out.println();
		//향상된 for문
		for(String tmp : listStr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		// remove(index) : index 번지의 값을 삭제 > List에서만 가능
		// remove(object) : object 요소를 삭제 > Set/Map 사용
		// return 값이 있음!!!
		System.out.println("--remove--");
		System.out.println(listStr.remove(0));
		System.out.println(listStr);
		System.out.println(listStr.remove("마"));
		System.out.println(listStr);
		
		// 숫자를 지울때는? value와 index 혼동을 어떻게 막을까
		System.out.println(list);
		Integer re = 10;
//		list.remove(10); // index를 찾음 > outofindex 예외
		list.remove(re); 
		System.out.println(list);
		
		
		// contains(object) : list에 값이 있는지 없는지 검사 t/f로 리턴
		System.out.println(listStr.contains("나"));
		
		// clear() : 리스트 비움
		listStr.clear();
		System.out.println(listStr);
		
		// isEmpty() : 리스트가 비어있는지 확인 t/f
		System.out.println(listStr.isEmpty());
		
		/* Iterator : index가 없는 자료형을 출력하기 위해 사용
		 * list는 index가 있기 때문에 get(i)를 사용하여 원하는 번지에 접근이 가능
		 * set / map은 index가 없어서 일반 for문은 사용불가 (향상된 for문은 가능/ but map은 이것마저 불가능..)
		 * 순서와 상관없이 값을 가져올 수 있는 Iterator 사용
		 * map은 향상된 for, Iterator 둘 다 직접 사용은 불가능 
		 * 
		 * 
		 */
		
		System.out.println("--Iterator 출력--");
		Iterator<Integer> it = list.iterator(); //리스트를 이터레이터 객체로 변환(복사)
		while(it.hasNext()) { //it 다음 요소 값이 있는지 체크 true/false
			Integer tmp = it.next(); // 다음 요소 가져오기
			System.out.println(tmp); 
		}
		
		// indexOf(object) : 해당 object의 index를 리턴 / 없으면 -1
		System.out.println(list.indexOf(re)); // 아까 빼서 없지요
		
		list.add(11);
		list.add(16);
		list.add(12);
		list.add(19);
		list.add(4);
		list.add(7);
		
		System.out.println(list);
		
		// 정렬 >> 위치가 존재하는 리스트만 가능함
		// Collections.sort() // 오름차순만가능
		Collections.sort(list);
		System.out.println(list);
		
		// list.sort(Comparator를 구현한 구현체) : 정렬
		// Comparator 인터페이스를 구현한 구현체를 넣어야함 (익명클래스 사용)
		// CompareTo : 사전상 앞이면 -1, 같으면 0, 뒤면 +1
		
		
		//내림차순
		list.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// 결과가 -면 앞으로 보내고, +면 뒤로 보냄
				// o1(2) - o2(1) : +니까 뒤로보냄 >> 오름차순
				// o2(1) - o1(2) : -니까 앞으로보냄 >> 내림차순
				return o2-o1;
				// String의 경우 compare을 사용해 사전상 앞뒤를 파악해줘야함
			}
		});
		
		System.out.println(list);
		
		
	}

}


//class a {
//	int a;
//}
