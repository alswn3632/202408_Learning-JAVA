package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File05 {

	public static void main(String[] args) throws IOException{
		// test.txt 파일을 읽어들여서 map에 저장
		// 명단, 합계, 평균 출력
		// 읽어들이는 파일은 모두 String - 계산을 위해서는 int로 변환이 필요함
		
		// 80점 이상인 학생 명단
		
		HashMap<String, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		
		while(true) {
			String line = br.readLine(); // 한 라인으로 읽어오기
			if(line == null) {
				break;
			}
			
			String arr [] = line.split(" ");
			map.put(arr[0].trim(), Integer.parseInt(arr[1]));
		}
		br.close();
		
		int sum = 0;
		
		System.out.println("---학생들 명단---");
		for(String key : map.keySet()) {
			sum+=map.get(key); 
			System.out.println(key+":"+map.get(key));
		}
		System.out.println("---합계와 평균---");
		System.out.println("합계:"+sum);
		System.out.println(String.format("평균: %.2f", sum / (double) map.size()));
		
		System.out.println("---80점 이상---");
		for(String key : map.keySet()) {
			if(map.get(key)>= 80) {				
			System.out.println(key+":"+map.get(key));
			}
		}
	}

}
