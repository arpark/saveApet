var anSystemInit = {

		 	$grid  : "anJqGrid",

		 	initGrid : function() {

		 		var gridOpt = {

		 			url			: "/saveApet/getAnimalProList.do",
		 			colNames	: ["관할구역","보호센터명", "전화번호", "보호센터 주소"],
		 			colModel	: [
		                  {index:'orgNm', name:'orgNm', width : "200px"},
		                  {index:'careNm', name:'careNm' , width : "140px"},
		                  {index:'careTel', name:'careTel' , width : "140px"},
		                  {index:'careAddr', name:'careAddr' , width : "418px"},
		 			],

		 			sortname	: "orgNm",
		 			sortorder   : "ASC",
		 			rownumbers 	: true,
		 			multiselect	: false,
		 			pginput 	: true,
		 			rowNum		: 10,
		 			
		 		}

		 		this.$grid = Cmmn_grid.init("anJqGrid","anJqGridPager", gridOpt).grid;
		 	}
		 	
}

$(function () {
	
	anSystemInit.initGrid();
	Cmmn_grid.setGrid(anSystemInit.$grid).search();
});


function anSearchBtnClick() {
	var param = {};
	param.care_nm = $("#careName").val();
	console.dir(param)
	Cmmn_grid.setGrid(anSystemInit.$grid).search(param);
}
