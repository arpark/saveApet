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
					<h2>반려동물등록제</h2>
					<ul>
						<li><a href="${ctx}/petReSystemMain.do">반려동물등록제란?</a></li>
						<li class="active"><a href="${ctx}/petReSystemListPage.do">대행업체리스트</a></li>
					</ul>
				</div>
			</div>
			<div class="contentsDiv">
				<div class="featured">
					<div class="searchDiv">
						<form name="peSearchFrm" id="peSearchFrm"  onsubmit="return false;">				
							<div class="SearchArea02">
							<fieldset class="boardSearchForm">
							  <legend>등록대행업체 검색<img class="searchIcon" alt="검색(search)" src="${ctx}/images/icons8-search-26.png"></legend>
				
							  <div class="searchList01">
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
							   <div class="searchList02">
								<span class="searchDate"><label for="orgNm">업체명 </label></span>
								<span><input type="text" title="업체명" id="orgNm" name="orgNm"></span>
								<span class="resultBtn">
								  <input id="peSelect" type="button" value="조회" alt="조회"> <!-- onclick="reSelectBtn()" -->
								</span>
							  </div>						
							</fieldset>
							</div>
						</form>
					</div>
				</div>
				<div class="featured">
				    <table id="peJqGrid"></table>
				    <div id="peJqGridPager"></div>
			    </div>
			</div>				
		</div>
	</div>

	<%@ include file="../common/default_footer.jsp" %>
	<script type="text/javascript" src="${ctx}/js/petRegistrationSystem/petReSystemList.js"></script>
</body>
</html>