package day10;

import java.io.IOException;

public class File01 {

	public static void main(String[] args) {
		// file : java.io.*에서 제공하는 클래스들은 try/catch 혹은 throws 처리를 해줘야함.
		// Input/OutputStream (I/OStream) : 단방향으로 데이터가 흘러가는 형태
		/* java는 입력스트림과 출력스트림을 통해서 데이터를 입출력함.
		 * 다양한 장치에 독립적으로 운영, 일관성있게 입출력을 유지하기 위해
		 * 입출력 스트림을 통해 일관성, 독립성 제공
		 * 
		 * ***두가지 형태의 스트림
		 * -바이트 형태의 스트림 : 기본(문자, 기본, 멀티미디어) 속도가 느림
		 * -문자 형태의 스트림 : 문자만 입출력할 때 사용
		 * 
		 * 1. 바이트 스트림 : 
		 * - 입력(InputStream) : FileInputStream, BufferedInputStream, DataInputStream ... 등등
		 * - 출력(OutputStream) : FileOutputStream, BufferedOutputStream, DataOutputStream ... 등등
		 * 
		 * 2. 문자 스트림 : 
		 * - 입력(Reader) : FileReader, BufferrdReader, InputStreamReader ...
		 * - 출력(Writer) : FileWriter, BufferrdWriter, PrintWriter ...
		 * 
		 * ***기반스트림 / 보조스트림
		 * 기반스트림 : 직접 자료를 읽고 쓰는 기능이 있는 스트림
		 * - FileInputStream, FileOutputStream, FileReader, FileWriter
		 * 보조스트림 : 직접 읽고 쓰는 기능은 없지만, 추가적인 기능을 더해주기 위한 스트림
		 * - Buffered~ 
		 */
		
		// 표준 출력(모니터 = 콘솔) 스트림
		System.out.println("print");
		
		// 표준 입력(키보드) 스트림
		try {
			// 바이트 단위 스트림
			int b = System.in.read();
			System.out.println(b); // A > 65
			System.out.println((char)b); // A > A
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 표준 에러 출력 스트림
		System.err.println("error");
		
		
		
		
		
	}

}
