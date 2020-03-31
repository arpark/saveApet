package egovframework.example.common.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class PagingUtil {

	public static Map<String, Object> setStartEndDisplay(Map<String, Object> params) {
		
		String pageno  = (String) params.get("pageno");
		String display = (String) params.get("display");
		
		if (pageno == null || !StringUtils.isNumeric(pageno)) {
			pageno = "1";
			params.put("pageno", pageno);
		}
		
		if (display == null || !StringUtils.isNumeric(display)) {
			display = "10";
			params.put("display", display);
		}
		
		int nPageno  = Integer.parseInt(pageno);
		int nDisplay = Integer.parseInt(display);
		
		int firstIndex = (nDisplay * (nPageno - 1) + 1);
		int lastIndex  = (nDisplay * (nPageno - 1) + nDisplay);
		
		params.put("firstIndex", firstIndex);
		params.put("lastIndex" , lastIndex);
		
		return params;
	}
}
