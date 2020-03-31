package egovframework.example.common.paging;

import javax.servlet.http.HttpServletRequest;

public interface PagingService {
	/**
	 * @Method Name	: setPaging
	 * @Author		: 이슬기
	 * @Date		: 2014. 11. 26.
	 * @사업명		: 국가자료공동목록 시스템(KOLIS-NET) 관리기능 개선
	 * @변경이력	: 
	 * @프로그램설명: 페이징을 지원
	 * @param strPage
	 * @param strTotalSize
	 * @param strFunctionName
	 * @param nViewList
	 * @param nViewNumber
	 * @param request
	 * @return
	 */
	public String setPaging(String strPage, String strTotalSize, String strFunctionName, int nViewList, int nViewNumber, HttpServletRequest request);
}
