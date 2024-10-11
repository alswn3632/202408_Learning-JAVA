package day07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Set01 {

	public static void main(String[] args) {
		/* Set : index가 없음. (순서보장X), 정렬X, 중복X
		 * HashSet(대표적인 Set) / TreeSet(정렬이 되는 Set)
		 * */
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(set);
		
		//set은 index가 없어서 get(i) / set(index, value) 없음.
		
		for(String s : set) {
			System.out.println(s);
		}
		System.out.println("------------");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp);
		}
		System.out.println("--------");
		
		//set => list 변경 후 처리. 
		List<String> list = new ArrayList<String>(set);
		System.out.println(list);

	}

}
