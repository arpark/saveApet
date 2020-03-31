<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/html_head.jsp"%>

<script>
	var M008004001 = {
			screenId		: "M008004001",
			$grid			: null,

			initGrid : function() {

				var gridOpt = {

					url			: "<c:url value='/getJqGirdData.do'/>",
					colNames	: ["No", "사번", "담당분야", "담당자명", "부서", "직책"],


					colModel	: [
						{name	: "rnum",			index	: "No",			width	: 55,		align : "center"},
						{name	: "adminNo",		index	: "사번",			width	: 100,		align : "center"},
						{name	: "adminNm",		index	: "담당분야",		width	: 100,		align : "center"},
						{name	: "posNm",			index	: "담당자명",		width	: 100,		align : "center"},
						{name	: "deptNm",			index	: "부서",			width	: 100,		align : "center"},
						{name	: "adminId",		index	: "직책",			width	: 100,		align : "center"}
					],

					multiselect	: false
				}

				this.$grid = Cmmn_grid.init(this.screenId, gridOpt).grid;

			},

			enterSearch	: function() {

				if (event.keyCode === 13) {
					M008004001.search();
				}
			},

			/* search	: function() {

				var param = cmmn.formToObj("testForm");

				grid.setGrid(this.$grid).search(param);
			} */
		}

$(function () {

	M008004001.initGrid();

});

</script>

<div id="test" class="grid"></div>