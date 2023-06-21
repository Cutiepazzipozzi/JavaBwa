import java.net.*;
import java.io.*;

public class ch15_networking {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://velog.io/@ddungdding";
		String line="";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=input.readLine())!=null) {
				System.out.println(line);
			}
			
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    // public static void main(String[] args) {
		
	// 	// IP주소를 다루기 위한 클래스
	// 	InetAddress ip = null;
	// 	InetAddress[] ipArr = null;
		
	// 	try {
	// 		ip = InetAddress.getByName("www.google.com");
	// 		System.out.println(ip.getHostName());
	// 		System.out.println(ip.getHostAddress());
	// 		System.out.println(ip.toString());
			
	// 		byte[] ipAddr = ip.getAddress();
	// 		System.out.println(Arrays.toString(ipAddr));
			
	// 		String result = "";
	// 		for(int i=0; i<ipAddr.length; i++) {
	// 			result += (ipAddr[i] < 0 ? ipAddr[i]+256 : ipAddr[i])+".";
	// 		}
	// 		System.out.println(result);
	// 		System.out.println();
			
	// 		ip = InetAddress.getLocalHost();
	// 		System.out.println(ip.getHostName());
	// 		System.out.println(ip.getHostAddress());
	// 		System.out.println();
			
	// 		ipArr = InetAddress.getAllByName("www.naver.com");
	// 		for(int i=0; i<ipArr.length; i++) {
	// 			System.out.println(i+". "+ipArr[i]);
	// 		}
            
	// 	} catch (UnknownHostException e) {
	// 		e.printStackTrace();
	// 	}
	// }
}
