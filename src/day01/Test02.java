package day01;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* <문제>
		 * 국어, 영어, 수학 세 점수의 합계와 평균을 출력
		 * if문을 이용해 평균이 80점 이상이면 pass 아니면 fail
		 */
		
		int kor = 78;
		int eng = 80;
		int math = 90;
		
		int sum = kor + eng + math;
		double avg = (double)sum / 3;
		String grade = "";
		
		if(avg >= 80){
			grade = "pass";
		}else{
			grade = "fail";
		}
		
		System.out.println("평균: " + avg + " " + grade);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
