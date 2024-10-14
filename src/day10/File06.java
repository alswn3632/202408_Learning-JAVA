package day10;

import java.io.File;

public class File06 {

	public static void main(String[] args) {
		// File 객체 : 경로 + 확장자  
		// D:\aws_chaminjoo\java_workspace\java_project
		// 파일 생성 
		// File.seperator : 파일 경로 구분자(운영체제마다 다름) \\ / 
		// txt, xml, json, csv https://www.data.go.kr/ 한국 데이터 포털
		// 데이터 센터 => xml json 형태로(가장많이 사용)
		
		File f = new File("D:\\aws_chaminjoo\\java_workspace\\java_project//test.txt");
		System.out.println(File.separator); // \
		String name = f.getName();
		// 파일명.확장자
		System.out.println(name); // test.txt
		// 경로 + 파일명 + 확장자
		System.out.println(f.getPath()); // D:\aws_chaminjoo\java_workspace\java_project\test.txt
		// 경로만
		System.out.println(f.getParentFile()); // D:\aws_chaminjoo\java_workspace\java_project

		// 파일 객체를 스트링으로 변환
		String f2 = f.toString();
		System.out.println(f2); // 객체가 아닌 String
		// String으로 변환 후 substring 사용이 가능
		String f2Name = f2.substring(f2.lastIndexOf(f.separator)+1);
		System.out.println(f2Name); // test.txt
		
		
	}

}
