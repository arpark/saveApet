package egovframework.example.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.XML;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("appserver")
public class Appserver {

	protected Logger logger = Logger.getLogger(Appserver.class);

	@Value("#{OPENAPI['openapi.url']}")
	protected String OPENAPI_URL;

	@Value("#{OPENAPI['openapi.ServiceKey']}")
	protected String OPENAPI_SERVICEKEY;

    @Value("#{OPENAPI['kakao.url']}")
    protected String KAKAO_URL;
    
    @Value("#{OPENAPI['kakao.key']}")
    protected String KAKAO_KEY;
    
    @SuppressWarnings({ "unchecked", "null" })
	public Map<String, Object> getOpenApi(Map<String, Object> map) {
    	
    	Map<String, Object> apiResult = new HashMap<String, Object>();
    	
		try {
			
			String apiURL = makeURl( OPENAPI_URL + map.get("baseURL") + map.get("gubun") + "?" + OPENAPI_SERVICEKEY, map);
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            
			int responseCode = con.getResponseCode(); 
			System.out.println("url: "+url);
			System.out.println("responseCode: "+responseCode);
            BufferedReader br;
            
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"UTF-8"));
            }
            
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            
            br.close();
	            
            org.json.JSONObject xmlJSONObj = XML.toJSONObject(response.toString());

            String xmlJSONObjString = xmlJSONObj.toString();

			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1 = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>(){});
			
			Map<String, Object> dataResponse = (Map<String, Object>) map1.get("response");
			Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
			
			Map<String, Object> items = new HashMap<String, Object>();
			List<Map<String, Object>> itemList = new ArrayList<Map<String,Object>>();
			
			int pageNo = (int) body.get("pageNo");
			int totalCount = (int) body.get("totalCount");
			int numOfRows = (int) body.get("numOfRows");
			
			System.out.println("totalCount - " + totalCount);
			
			if (totalCount > 0) {
			
				items = (Map<String, Object>) body.get("items");
				
				if (totalCount == 1) {
					
					itemList.add(0, (Map<String, Object>) items.get("item"));

				}else {
					itemList = (List<Map<String, Object>>) items.get("item");
				}
			}
			
        	apiResult.put("apiData", itemList);
        	apiResult.put("pageNo", pageNo);
        	apiResult.put("totalCount", totalCount);
        	apiResult.put("numOfRows", numOfRows);
        	
            return apiResult;
	            
		} catch(Exception e) {
			   e.printStackTrace();
			return null;
		}
    }
  
    
    private String makeURl(String baseURL , Map<String, Object> data)throws Exception{
    	
    	for (String key : data.keySet()) {
    		
    		if (!key.equals("gubun") && !key.equals("baseURL") && !data.get(key).equals("")) {
    			baseURL+="&"+key+"="+ URLEncoder.encode(data.get(key).toString(), "UTF-8");

			}
		}
    	
        logger.info(baseURL);
        return baseURL;
    }
    
    
    public JSONObject getApi(HashMap<String, Object> map) {
    	JSONObject apiJson = null;
		
		try {
			String kakaoKey = KAKAO_KEY;
			String addr = URLEncoder.encode(map.get("address").toString(), "UTF-8");
			String apiURL = KAKAO_URL + addr;
			System.out.println("apiURL: "+apiURL);
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "KakaoAK " + kakaoKey);
            
			int responseCode = con.getResponseCode(); 
			System.out.println("responseCode: "+responseCode);
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            String responseStr = response.toString();
            
            JSONParser parser = new JSONParser();
            apiJson = (JSONObject) parser.parse(responseStr);
	            
		} catch(Exception e) {
			logger.error(e);
			return null;
		}
		return apiJson;
    }
  }