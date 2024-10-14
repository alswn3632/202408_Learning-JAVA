package day10;

import java.io.IOException;

public class File02 {

	public static void main(String[] args) {
		// System.in을 이용하여 알파벳 받기
		// Enter를 인식 == '\n'
		
		System.out.print("알파벳 입력: ");
		try {
			int in; // read() 입력 받은 값을 무조건 int 형으로 리턴
			while((in = System.in.read()) != '\n') {
				System.out.print((char)in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
