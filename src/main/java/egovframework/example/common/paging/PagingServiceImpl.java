package egovframework.example.common.paging;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("pagingService")
public class PagingServiceImpl extends EgovAbstractServiceImpl implements PagingService {
	public String setPaging(String strPage, String strTotalSize, String strFunctionName, int nViewList, int nViewNumber, HttpServletRequest request) {
	
		StringBuffer sbuf 	= new StringBuffer();
		String sPageString 	= null;
		int pageno 			= Integer.parseInt(strPage);
		
		if(pageno < 1) {
			pageno = 1;
		}
		
		int total_record = Integer.parseInt(strTotalSize);
		
		if(total_record < 1) {
			total_record = 1;
		}
		
		int page_per_record_cnt = nViewList;
		int group_per_page_cnt = nViewNumber;
		int record_end_no = pageno * page_per_record_cnt;
		
		if(record_end_no > total_record) {
			record_end_no = total_record;
		}									   
											   
		int total_page = 0;
		
		if(total_record >= 1000) {
			total_page = total_record / page_per_record_cnt + 1;
		} else {
			total_page = total_record / page_per_record_cnt + (total_record % page_per_record_cnt > 0 ? 1 : 0);
		}
		
		if(pageno>total_page) {
			pageno = total_page;
		}
		
		int group_no = pageno / group_per_page_cnt + ( pageno % group_per_page_cnt > 0 ? 1 : 0);
		int page_eno = group_no * group_per_page_cnt;		
		int page_sno = page_eno - (group_per_page_cnt - 1);
		
		if(page_eno > total_page) {
			page_eno = total_page;
		}
		
		int prev_pageno = page_sno-group_per_page_cnt;	
		int next_pageno = page_sno+group_per_page_cnt;
		
		if(prev_pageno < 1) {
			prev_pageno = 1;
		}
		
		if(next_pageno > total_page) {
			next_pageno = total_page;
		}
		
		String strContextPath = request.getContextPath();
		
		sbuf.append("<a href='javascript:").append(strFunctionName).append("(1)").append("'><i class='fas fa-angle-double-right' alt='맨앞으로' title='맨앞으로'></i></a>");
		sbuf.append("<a href='javascript:").append(strFunctionName).append("(").append(prev_pageno).append(")' style='margin-right: 5px;'><i class='fas fa-angle-right'  alt='이전' title='이전' /></a>");
		
		for(int i = page_sno; i <= page_eno; i++) {
			
			if(pageno == i) {
				sbuf.append("<a href='javascript:;' style='text-decoration:none; margin-right:5px; cursor:default;'> ");
				sbuf.append("<b>").append(i).append("</b>");
			} else {
				sbuf.append("<a href='javascript:").append(strFunctionName).append("(").append(i).append(")' style='text-decoration:none; margin-right:5px;'> ");
				sbuf.append(i);
			} 
			sbuf.append(" </a>");
			
			
			
			if(i < page_eno) {
				
			}
		}
			
		sbuf.append("<a href='javascript:").append(strFunctionName).append("(").append(next_pageno).append(")'><i class='fas fa-angle-right' alt='다음' title='다음' /></a>");
		sbuf.append("<a href='javascript:").append(strFunctionName).append("(").append(total_page).append(")'><i class='fas fa-angle-double-right' alt='맨뒤로' title='맨뒤로' /></a>");
		sPageString = sbuf.toString();
		
		return sPageString;
	}
}
