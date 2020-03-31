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
					<h2>동물보호센터 안내</h2>
				</div>
			</div>
			<div class="contentsDiv">
				<div class="featured">
					<div class="searchDiv">
						<form name="anSearchFrm" id="anSearchFrm" onsubmit="return false;">				
							<div class="SearchArea02">
							<fieldset class="boardSearchForm">
							  <legend>등록대행업체 검색<img class="searchIcon" alt="검색(search)" src="${ctx}/images/icons8-search-26.png"></legend>
				
							  <div class="searchList">
								<!-- <label for="selectUprCd"><span class="searchSiDo">시도</span></label>
								<span>
								  <select class="careList" id="selectUprCd" name="selectUprCd" onchange="uprCdChange(this.value)">
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
								  <select class="SiGunList" id="selectOrgCd" name="selectOrgCd" onchange="anOrgCdChange(this.value)">
									<option value="0000000">선택</option>
								  </select>
								</span> -->
								<label for="caraName"><span class="caraName">보호센터명</span></label>
								<span><input type="text" title="보호센터명" id="careName" name="careName" onkeypress="if(event.keyCode==13) anSearchBtnClick()" ></span>
								<span class="resultBtn">
								  <input id="anSearchBtn" type="button" value="조회" alt="조회"  onclick="anSearchBtnClick()" >
								</span>
							  </div>	
							  <div class="searchList">
								<span class="sm">※보호센터명을 정확히 입력해주세요.</span>
							  </div>
							</fieldset>
							</div>
						</form>
					</div>
				</div>
				<div class="featured">
					<span id="anTotalCnt"></span>
				    <table id="anJqGrid"></table>
				    <div id="anJqGridPager"></div>
			    </div>
			</div>				
		</div>
	</div>

	<%@ include file="../common/default_footer.jsp" %>
	<script type="text/javascript" src="${ctx}/js/animalProtectionCenter/animalProMain.js"></script>

</body>
</html>