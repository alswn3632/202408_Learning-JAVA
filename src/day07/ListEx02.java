package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListEx02 {

	public static void main(String[] args) {
		// 두 배열을 하나의 리스트로 합치기
		// 정렬하여 출력 (오름, 내림차순)
		
		//직접 해당 값을 리스트로 옮기기
		//Arrays.asList() : 배열 => 리스트
		//toArray() : 리스트 => 배열
		
		String arr1[] = {"a","g","f","h","c"};
		String arr2[] = {"b","t","s","p","n","m"};
		
		List<String> list2 = Arrays.asList(arr1);
		System.out.println(list2);
		// 배열과 list가 연결되어있는 상태 추가 불가능 / 수정가능
		// 리스트 == 배열 원본 배열 변경
//		list2.add("z");
//		list2.set(0, "z");
//		System.out.println(list2);
		
		System.out.println("-- new ArrayList arr1 -- ");
		List<String> list3 = new ArrayList<>(Arrays.asList(arr1));
		System.out.println(list3);
		list3.add("z");
		System.out.println(list3);
		System.out.println("-- new ArrayList arr2 -- ");
		List<String> list4 = new ArrayList<>(Arrays.asList(arr2));
		System.out.println(list4);
		
		System.out.println("-- list addAll --");
		list3.addAll(list4);
		System.out.println(list3);
		
		// List를 배열로 변환
		int listSize = list3.size();
		System.out.println("---리스트를 배열로 변환--");
		String[] arr = list3.toArray(new String[listSize]);
		System.out.println(Arrays.toString(arr));
		
		list3.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(list3);
		
		System.out.println("--손수 옮기기--");
		List<String> list = new ArrayList<>();
		
		int cnt = arr1.length + arr2.length;
		int i=0, j=0;
		while(cnt > list.size()) {
			if(i<arr1.length) {
				list.add(arr1[i]);
				i++;
			}
			if(j<arr2.length) {
				list.add(arr2[j]);
				j++;
			}
		}
		System.out.println(list);
		list.add("z");
		System.out.println(list);
		
	}
	
}
