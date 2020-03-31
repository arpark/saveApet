package egovframework.example.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class commonUtil {

	/**
     * FuncName : getApiData()
     * FuncDesc : apiData -> List Map 형태 변환
     * Param    : param : Map
     * Return   : List<Map<String, Object>>
    */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getApiData(Map<String, Object> result) throws Exception {
		List<Map<String, Object>> items = (List<Map<String, Object>>) result.get("apiData");
		
		List<Map<String, Object>> getApiData = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < items.size(); i++) {
			
			Map<String, Object> apiData = new HashMap<String, Object>();
			Map<String, Object> item = items.get(i);
			
			for (String key : item.keySet()) {
				apiData.put(key, item.get(key));
			}
			getApiData.add(i, apiData);
			
		}
		
		return getApiData;
		
	}
	
	/**
     * FuncName : getApiDataGridForm()
     * FuncDesc : apiData -> List Map 형태 변환 (그리드에 들어갈 형태로 변환)
     * Param    : param : Map
     * Return   : List<Map<String, Object>>
    */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getApiDataGridForm(Map<String, Object> result, String gubun) throws Exception {
		List<Map<String, Object>> getApiData = new ArrayList<Map<String, Object>>();

		List<Map<String, Object>> items = (List<Map<String, Object>>) result.get("apiData");
		int totalCount = Integer.parseInt(result.get("totalCount").toString());
		
		if (totalCount > 0) {
			for (int i = 0; i < items.size(); i++) {
				
				Map<String, Object> apiData = new HashMap<String, Object>();
				Map<String, Object> item = items.get(i);
				
				String orgAddr = "";
				String orgAddrDtl = "";
				for (String key : item.keySet()) {
					
					if (key.equals("orgAddr")) {
						orgAddr = item.get(key).toString();
						
					}else if (key.equals("orgAddrDtl")) {
						
						orgAddrDtl = item.get(key).toString();
					} else {
						
						apiData.put(key, item.get(key));
					}

				}
				
				if (gubun.equals("recordAgency")) {
					apiData.put("addr", orgAddr + orgAddrDtl);
				}
				
				getApiData.add(i, apiData);
			}
		} 
		
		Map<String, Object> map = new HashMap<String, Object>();
    	
    	map.put("rows", getApiData);
    	map.put("page", result.get("pageNo"));

    	Object total_page;
    	int page_per_record_cnt = (int) result.get("numOfRows");
    	
    	if((int)totalCount >= 1000) {
			total_page =  totalCount / page_per_record_cnt + 1;
		} else {
			total_page = totalCount / page_per_record_cnt + (totalCount % page_per_record_cnt > 0 ? 1 : 0);
		}
    	
		map.put("total", total_page);
		map.put("records", totalCount);
		
		return map;
		
	}
}
