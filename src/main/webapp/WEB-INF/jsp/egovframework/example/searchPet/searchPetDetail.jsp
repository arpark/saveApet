<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/html_head.jsp"%>

<script type="text/javascript"> 
    $(document).ready(function () {
        $("#jqGrid").jqGrid({
            url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
            mtype: "GET",
            datatype: "jsonp",
            colModel: [
                { label: 'OrderID', name: 'OrderID', key: true, width: 75 },
                { label: 'Customer ID', name: 'CustomerID', width: 150 },
                { label: 'Order Date', name: 'OrderDate', width: 150,
	formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
                { label: 'Freight', name: 'Freight', width: 150 },
                { label:'Ship Name', name: 'ShipName', width: 150 }
            ],
viewrecords: true,
            width: 780,
            height: 250,
            rowNum: 20,
            pager: "#jqGridPager"
        });
    });

</script>
</head>
<body>
	<%@ include file="../common/default_header.jsp"%>

	<div id="contents">
		<div class="clearfix">
			<div class="featured">
				<div class="searchDiv">
					<form name="searchFrm" method="post"
						action="/portal_rnl/abandonment/loss_list.jsp">

						<!--검색영역-->

						<div class="SearchArea02">
							<input type="hidden" id="pagecnt" name="pagecnt" value="">
							<fieldset class="boardSearchForm">

								<legend>
									유기동물검색<img class="searchIcon" alt="검색(search)"
										src="images/icons8-search-26.png">
								</legend>

								<div class="searchList01">
									<span style="color: #8c0000;">날짜 입력시 다음 예 와같이 입력해주세요
										예)2011-01-01</span><br> <span class="searchDate"><label
										for="s_date">날짜 </label></span>

									<!-- llhmkll86 - CrossBrowsing 달력수정 -->


									<!-- 수정 소스-->

									<!-- 끝-->


									<!-- <span><a href="#e_date" onclick="Calendar(document.searchFrm.e_date);"><img src="/portal_rnl/images/sub/btn_calendar.gif" alt="달력(검색종료날짜)"/></a></span> -->
									<span><input type="text" title="기간(부터) 검색시작일자"
										id="s_date" name="s_date"
										onblur="chkDate(this.value, this.id);" class="tcal tcalInput"
										size="12" maxlength="10" value=""></span> <span>~</span> <span><input
										type="text" title="기간(까지) 검색종료일자" id="e_date" name="e_date"
										onblur="chkDate(this.value, this.id);" class="tcal tcalInput"
										size="12" maxlength="10" value=""></span>

								</div>

								<div class="searchList02">
									<label for="s_upr_cd"><span class="searchSiDo">시도</span></label>
									<span> <select class="SidoList" id="s_upr_cd"
										name="s_upr_cd"
										onchange="set_org_cd2(this.value); return false;">
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
									</span> <label for="s_org_cd"><span class="searchSiGun">시군구</span></label>
									<span> <select class="SiGunList" id="s_org_cd"
										name="s_org_cd">
											<option value="0000000">선택</option>

									</select>
									</span>
								</div>
							</fieldset>
						</div>
					</form>
				</div>
			</div>
			<div class="featured">
				
			    <table id="jqGrid"></table>
			    <div id="jqGridPager"></div>
			</div>
		</div>
	</div>	

	<%@ include file="../common/default_header.jsp" %>
</body>
</html>