package day10;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File03 {

	public static void main(String[] args) throws IOException{
		// FileWriter를 통해 파일 쓰기
		// 다시 실행하면 같은 이름의 파일로 덮어쓰기
		
		FileWriter fw = new FileWriter("writer.txt");
		for(int i=1; i<=10; i++) {
			// \r : 캐리지 리턴, \n : Enter
			String data = i + "test \r\n";
			fw.write(data); // 파일에 기록
			fw.write("my project I/O Test \r\n");
		}
		fw.close();
		
		// 기존 파일의 데이터를 쓰려고 할 때 : 추가 모드
		FileWriter fw2 = new FileWriter("writer.txt", true);
		for(int i=11; i<=20; i++) {
			// \r : 캐리지 리턴, \n : Enter
			String data = i + "test2 \r\n";
			fw2.write(data); // 파일에 기록
			fw2.write("my project I/O Test \r\n");
		}
		fw2.close();
		
		// PrintWriter
		PrintWriter pw = new PrintWriter("writer2.txt");
		for(int i=1; i<=10; i++) {
			String data = i+ "PrintWriter Test. \r\n";
			pw.write(data);
		}
		pw.close();
		
		// 파일에 내용을 추가하려면...?
		PrintWriter pw2 = new PrintWriter(new FileWriter("writer2,txt", true));
		for(int i=11; i<=20; i++) {
			String data = i+ "Append Mode. \r\n";
			pw2.write(data);
		}
		pw.close();
		
		// 바이트 기반 스트림
		// fileOutputStream을 이용한 파일 쓰기
		FileOutputStream output = new FileOutputStream("out.txt");
		for(int i=1; i<=10; i++) {
			String data = i+ ". 한글로도 써보기 Test \r\n";
			// 바이트 기반 스트림이기 떄문에 바이트 단위로 써야함
			output.write(data.getBytes());
		}
		output.close();
		
	}
	
}
	