package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
		DataOutputStream dos = null;
		BufferedReader br = null;
		
		// api 주소
		String apiURL = "http://localhost:8090/NaverPostRequestor/index.jsp";
		
		URL url = new URL(apiURL);
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		
		dos = new DataOutputStream(conn.getOutputStream());
		
		String params = "name=" + "hhh" + "&message=" + "nice to meet you";
		dos.writeBytes(params);
		
		//////////////////recv 받다
		
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String oneLine, sum = "";
		
		while((oneLine = br.readLine()) != null ) {
			sum += oneLine;
		}
		
		System.out.println(sum);
		
		// 마무리 작업
		if(br != null) br.close();
		if(dos != null) dos.close();
	}

}
