var peSystemInit = {

		 	$grid  : "peJqGrid",

		 	initGrid : function() {

		 		var gridOpt = {

		 			url			: "/saveApet/getPetReSystemList.do",
		 			colNames	: ["업체명","대표자명", "업체 전화번호", "주소"],
		 			colModel	: [
		                  {index:'orgNm', name:'orgNm', width : "200px"},
		                  {index:'memberNm', name:'memberNm' , width : "140px"},
		                  {index:'tel', name:'tel' , width : "140px"},
		                  {index:'addr', name:'addr' , width : "418px"},
		 			],

		 			sortname	: "orgNm",
		 			sortorder   : "ASC",
		 			rownumbers 	: true,
		 			multiselect	: false,
		 			pginput 	: true,
		 			rowNum		: 10,
		 			
		 		}

		 		this.$grid = Cmmn_grid.init("peJqGrid","peJqGridPager", gridOpt).grid;
		 	},
		 	
		searchData  : {},
}

$(function () {

	peSystemInit.initGrid();
	
	Cmmn_grid.setGrid(peSystemInit.$grid).search();
});


$("#peSelect").on("click",function() {
		
		var param = {};
		param.orgNm = $("#orgNm").val();
		
		var selectUprCd = $('#peSearchFrm [name=selectUprCd] option:selected').text();
		if (selectUprCd != "전체") {
			var selectOrgCd = $('#peSearchFrm [name=selectOrgCd] option:selected').text();
			
			param.addr = selectOrgCd != "전체" ? selectOrgCd : selectUprCd;
			
		}
		
		console.dir(param)
		Cmmn_grid.setGrid(peSystemInit.$grid).search(param);
})
	
