package day09;

import java.util.ArrayList;
import java.util.Comparator;

public class Stream03 {

	public static void main(String[] args) {
		/* Student 클래스로 리스트 구성
		 * Student 이름, 점수만 가지는 클래스
		 * 
		 * 학생 5명을 추가하고, 콘솔에 출력
		 * ex. 홍길동 : 80
		 */
		
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		stuList.add(new Student("신짱구", 50));
		stuList.add(new Student("한유리", 80));
		stuList.add(new Student("이훈이", 90));
		stuList.add(new Student("맹구", 40));
		stuList.add(new Student("김철수", 60));
		
		stuList.stream().forEach(System.out::println);
		
		//list의 점수 합계, 전체 인원수
		int sum = stuList.stream().mapToInt(n->n.getScore()).sum();
		System.out.println("점수합계: " + sum);
		long cnt = stuList.stream().count();
		System.out.println("인원수: " + cnt);
		System.out.println("---------------------");
		
		//이름순으로 정렬하여 출력
		stuList.stream().sorted(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		}).forEach(System.out::println);
		
		
	}

}

class Student {
	private String name;
	private int score;
	
	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + ": " + score + "점";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}