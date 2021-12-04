package ObjDetection;

import java.io.BufferedReader;  
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;


public class ObjDetectionTest {

	public static void main(String[] args) {
		
		StringBuffer reqStr = new StringBuffer();
        String clientId = "uc367pfcjp";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "Fce5ChJwxPHg8nirEO0aVe5AsKNzGkuljd9NNXCB";//애플리케이션 클라이언트 시크릿값";

        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = "C:\\temp\\movie.PNG";
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect"; // 객체 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                JSONParser jsonParser = new JSONParser();
                JSONObject obj = new JSONObject(response.toString());
                JSONArray objArray = (JSONArray)obj.get("predictions");
                
                for(int i=0; i<objArray.length(); i++) {
                	JSONObject preobj = (JSONObject) objArray.get(i);
                	JSONArray picArray = (JSONArray) preobj.get("detection_names");
                	ArrayList<String> list = new ArrayList<String>();
                	if (picArray != null) { 
                		   int len = picArray.length();
                		   for (i=0;i<len;i++){ 
                		    list.add(picArray.get(i).toString());
                		   } 
                	} 
                	System.out.println(list);
                	Set<String> set = new HashSet<String>(list);
                	for(String str : set) {
                		System.out.println("객체: "+str + ", " + Collections.frequency(list, str) + "개");
                	}
                	
                	Map<String, Integer> map = new HashMap<String, Integer>();
                	
                	for(String str : list) {
                		Integer count = map.get(str);
                		if(count == null) {
                			map.put(str, 1);
                		}else {
                			map.put(str, count + 1);
                		}
                		
                	}
                	//System.out.println(Collections.max(map.values()));
                    int maxValue = Collections.max(map.values());
                    for(Map.Entry<String, Integer> m : map.entrySet()) {
                    	if(m.getValue() == maxValue) {
                    		System.out.println("가장 많이 인식된 오브젝트는 " + m.getKey() + "입니다.");
                    	}
                    	
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

	}
	
}