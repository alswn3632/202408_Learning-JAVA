package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File04 {

	public static void main(String[] args) throws IOException{
		// 파일 읽기
		// BufferedReader : 문자 보조스트림
		/* 라인 단위로 읽기 가능 
		 * 더 이상 읽을 라인이 없다면 (null을 리턴) -> 그만!
		 * 보조 스크림 : 직접 읽고 쓰는 기능이 없기 때문에
		 * 기반 스크림을 매개변수로 포함해야 함
		 * 
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new FileReader("writer.txt"));
		
		while(true) {
			String line = br.readLine(); // 한 라인으로 읽어오기
			if(line == null) {
				break;
			}
			System.out.println(line);
		}
		br.close();
		
		
	}

}
