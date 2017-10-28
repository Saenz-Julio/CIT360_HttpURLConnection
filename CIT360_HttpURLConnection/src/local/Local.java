package local;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Local {
	
	private static Scanner in;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		String email = null;
		String password = null;
		System.out.println("Please enter your email: ");
		email = in.next();
		
		System.out.println("Please enter your password: ");
		password = in.next();
		
		String urlLink = "http://localhost/java/java.php?email="+email+"&password="+password;
		URL url = new URL(urlLink);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		
		while ((line = in.readLine()) != null){
			sb.append(line);
		}
		in.close();
		System.out.println(sb.toString());
		
	}

}
