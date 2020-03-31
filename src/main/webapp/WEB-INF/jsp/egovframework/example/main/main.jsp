<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<%@ include file="../common/html_head.jsp" %>
</head>
<body>
	<%@ include file="../common/default_header.jsp" %>
	
	<div id="contents">
			<div class="clearfix">
				<div class="featured">
					<div class="searchDiv">
					  <form name="searchFrm" method="post" action="/portal_rnl/abandonment/loss_list.jsp">				
						<div class="SearchArea02">
						<fieldset class="boardSearchForm">
			
						  <legend>유기동물검색<img class="searchIcon" alt="검색(search)" src="${ctx}/images/icons8-search-26.png"></legend>
			
						  <div class="searchList01">
							<span class="searchDate"><label for="s_date">날짜 </label></span>
			
							<span><input type="text" title="기간(부터) 검색시작일자" id="s_date" data-date="start" readonly></span>
							<span>~</span>
							<span><input type="text" title="기간(까지) 검색종료일자" id="e_date" data-date="start" readonly></span>
							
						  </div>
			
						  <div class="searchList02">
							<label for="s_upr_cd"><span class="searchSiDo">시도</span></label>
							<span>
							  <select class="SidoList" id="selectUprCd" onchange="uprCdChange(this.value)">
								<option value="">전체</option>
											  <option value="6110000">서울특별시</option>
											  <option value="6260000">부산광역시</option>
											  <option value="6270000">대구광역시</option>
											  <option value="6280000">인천광역시</option>
											  <option value="6290000">광주광역시</option>
											  <option value="5690000">세종특별자치시</option>
											  <option value="6300000">대전광역시</option>
											  <option value="6310000">울산광역시</option>
											  <option value="6410000">경기도</option>
											  <option value="6420000">강원도</option>
											  <option value="6430000">충청북도</option>
											  <option value="6440000">충청남도</option>
											  <option value="6450000">전라북도</option>
											  <option value="6460000">전라남도</option>
											  <option value="6470000">경상북도</option>
											  <option value="6480000">경상남도</option>
											  <option value="6500000">제주특별자치도</option>
							  </select>
							</span>
							<label for="s_org_cd"><span class="searchSiGun">시군구</span></label>
							<span>
							  <select class="SiGunList" id="selectOrgCd">
								<option value="0000000">선택</option>
							  </select>
							</span>
						  </div>							
						  <div class="searchList03">
							<label for="s_up_kind_cd"><span class="animalKind">품종</span></label>
							<select class="KindList01" title="품종선택" id="s_up_kind_cd" name="s_up_kind_cd">
							  <option value="">전체</option>
							  <option value="417000">개</option>
							  <option value="422400">고양이</option>
							  <option value="429900">기타</option>
							</select>								
							<span class="resultBtn">
							  <input class="memInfoBtn" id="select_img3" type="image" src="/portal_rnl/images/sub/btn_search01.gif" onclick="setting()" alt="조회">
							</span>
						  </div>
						</fieldset>
						</div>
						</form>
					</div>
				  </div>
				<div class="boardList">
					<h2>최근 유기동물</h2>
					
					<c:set var="i" value="0" />
					<c:set var="cnt" value="0" />
					<ul class="list">
						<c:forEach items="${petList}" var="list" begin="${cnt}">
							<c:if test="${i eq 2}">
								<c:set var="i" value="0" />
								<c:set var="cnt" value="${cnt+2}" />
							</c:if>
							<c:if test="${i ne 2}">
								<li class="first">
			                    	<div class="photo">
			                                <div class="thumbnail">
				                                <a target="_blank" title="클릭시 새창이 열립니다." onclick="imgPopup('${list.popfile}')" onkeypress="this.onclick(); return false;">
				                                	<img src="${list.filename}" alt="보호중동물사진 공고번호-'${list.notionNo}'">
		                                        </a>
			                                </div>
			                                <button class="moreBtn">자세히보기</button>
			                            </div>
			                            <div class="txt">
			                               		<dl><dt>공고번호</dt><dd>${list.noticeNo}</dd></dl>
										        <dl><dt>접수일자</dt><dd>${list.noticeSdt}</dd></dl>
										        <dl><dt>품종</dt><dd>${list.kindCd}</dd></dl>
										        <c:if test="${list.sexCd eq 'M'}">
											        <dl><dt>성별</dt><dd>수컷</dd></dl>
												</c:if>
												 <c:if test="${list.sexCd eq 'F'}">
											        <dl><dt>성별</dt><dd>암컷</dd></dl>
												</c:if>
										        <dl><dt>발견장소</dt><dd>${list.happenPlace}</dd></dl>
										        <dl><dt>특징</dt><dd>${list.specialMark}</dd></dl>
										        <dl><dt>상태</dt><dd>${list.processState}</dd></dl>
			                            </div>
			                        </li>
								<c:set var="i" value="${i+1}" />
							</c:if>
						</c:forEach>	
					</ul>
				  </div>
				</div>
		</div>
		
	<%@ include file="../common/default_footer.jsp" %>
	<script type="text/javascript" src="${ctx}/js/main/main.js"></script>
</body>
</html>