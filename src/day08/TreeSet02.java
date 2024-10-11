package day08;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSet02 {

	public static void main(String[] args) {
		
		Integer[] score = {80,79,85,46,35,84,75,96,82};
//		List<Integer> list = new ArrayList<>(Arrays.asList(score));
		TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(score));
//		for(int s : score) {
//			set.add(s);
//		}
//		System.out.println(set);
		
		// headSet(value) : value보다 작은값 
		// tailSet(value) : value보다 큰값
		System.out.println("-----");
		System.out.println(set.headSet(70));
		System.out.println(set.tailSet(70));
	}

}
