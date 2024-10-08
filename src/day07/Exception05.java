package day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exception05 {

	public static void main(String[] args) {
		// I/O Exception 발생 예제
		
		InputStreamReader isr = new InputStreamReader(System.in);
		// System.in 부분에 파일을 넣으면 파일에서 가져오겠지?
		BufferedReader br = new BufferedReader(isr);
		
		String name;
		try {
			name = br.readLine();
			System.out.println(name);
			br.close();
			isr.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
