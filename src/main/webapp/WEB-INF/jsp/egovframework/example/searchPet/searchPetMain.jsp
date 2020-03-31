<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/html_head.jsp"%>
</head>
<body>
	<%@ include file="../common/default_header.jsp"%>
	<div id="contents">
		<div class="wrap">
			<div class="sidebar">
				<div>
					<h2>유기동물검색</h2>
				</div>
			</div>
			<div class="contentsDiv">
				<div class="featured">
					<div class="searchDiv">
						<form id="searchFrm" name="searchFrm" onsubmit="return false;">				
							<div class="SearchArea02">
							<fieldset class="boardSearchForm">
							  <legend>유기동물검색<img class="searchIcon" alt="검색(search)" src="${ctx}/images/icons8-search-26.png"></legend>
							  <div class="searchList01">
								<span class="searchDate"><label for="s_date">날짜 </label></span>
								<span><input type="text" title="기간(부터) 검색시작일자" id="s_date" name="s_date" readonly></span>
								<span>~</span>
								<span><input type="text" title="기간(까지) 검색종료일자" id="e_date" name="e_date" readonly></span>
							  </div>
				
							  <div class="searchList02">
								<label for="selectUprCd"><span class="searchSiDo">시도</span></label>
								<span>
								  <select class="SidoList" id="selectUprCd" name="selectUprCd" onchange="uprCdChange(this.value)">
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
								<label for="selectOrgCd"><span class="searchSiGun">시군구</span></label>
								<span>
								  <select class="SiGunList" id="selectOrgCd" name="selectOrgCd">
									<option value="0000000">선택</option>
								  </select>
								</span>
							  </div>							
							  <div class="searchList03">
								<label for="upKindCd"><span class="animalKind">품종</span></label>
								<select class="KindList01" title="품종선택" id="kindCd" name="kindCd">
								  <option value="">전체</option>
								  <option value="417000">개</option>
								  <option value="422400">고양이</option>
								  <option value="429900">기타</option>
								</select>	
								
								<label for="processState"><span class="animalPro">상태</span></label>
								<select class="animalPro" title="상태선택" id="processState" name="processState">
								  <option value="">전체</option>
								  <option value="0">종료</option>
								  <option value="1">보호중</option>
								</select>	
								<span class="resultBtn">
								  <input id="petSearchBtn" type="button" value="조회" alt="조회" onclick="petSearchBtnClick()"> 
								</span>							
							  </div>
							</fieldset>
							</div>
						</form>
					</div>
				</div>
				<div class="boardList" >
					<h2>최근 유기동물</h2>
					<div class="contents_count_left">
				    	<span class="total_cnt">총 검색건수: <strong><span id="search_total">0</span> 건</strong></span>
				    </div>
					<ul class="list" id="petListUl"></ul>
					<div id="paging" class="paging_kn"></div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common/default_footer.jsp"%>
	<script type="text/javascript" src="${ctx}/js/searchPet/searchPet.js"></script>
</body>
</html>
