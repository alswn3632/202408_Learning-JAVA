package day11;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Netword01 {

	public static void main(String[] args) throws IOException{
		// 인터넷 주소의 정보를 확인
		InetAddress ip = null;
		ip = InetAddress.getByName("www.naver.com");
		System.out.println("HostAddress: " + ip.getHostAddress());
		// HostAddress: 223.130.192.248
		System.out.println("HostName: " + ip.getHostName());
		// HostName: www.naver.com

		System.out.println(ip.toString());
		// www.naver.com/223.130.192.248
		
		URL url = new URL("https://news.naver.com/main/list.naver?mode=LPOD&mid=sec&sid1=001&sid2=140&oid=001&isYeonhapFlash=Y&aid=0014983427");
		
		System.out.println(url.getContent());
		// sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@639c2c1d
		System.out.println(url.getAuthority());
		// news.naver.com
		System.out.println(url.getDefaultPort());
		// 443
		System.out.println(url.getProtocol());
		// https
		System.out.println(url.getHost());
		// news.naver.com

		// 아래 두개 중요 **
		System.out.println(url.getQuery());
		// mode=LPOD&mid=sec&sid1=001&sid2=140&oid=001&isYeonhapFlash=Y&aid=0014983427
		System.out.println(url.getPath());
		// /main/list.naver

		
	}
	

}
