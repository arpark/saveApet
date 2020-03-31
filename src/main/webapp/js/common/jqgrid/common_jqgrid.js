/**
 * jqgrid 
 */
var Cmmn_grid = (function() {

	var _$grid 		= "";
	var _$pager		= "";

	// jqgrid 타겟 저장
	var _setGrid 		= function(grid) {
		_$grid = grid;

		return this;
	}

	// jqgrid 타겟 가져오기
	var _getGrid 		= function() {
		return _$grid;
	}

	// jqgrid page 타겟 저장
	var _setPager 		= function(pager) {
		_$pager = pager;
	}

	// jqgrid page 타겟 가져오기
	var _getPager 		= function() {
		return _$pager;
	}

	// jqgrid 기본 옵션
	var _default = {
		url				: "",							// [★필수★] [호출 url]
		colNames 		: [],							// [★필수★] [컬럼 이름]
		colModel 		: [],							// [★필수★] [컬럼 속성]
		datatype 		: "local",
		cmTemplate		: { sortable: true },			// [헤더 sort 기능] false 일 시 sort 안함.
		rowNum			: 30,							// [페이지 당 데이터 row 수]
		rowList			: [10, 30, 50, 70],				// [row 수 선택 select box 값]
		pager			: _getPager(),					// [페이징]
		caption	 		: "",
		rownumbers 		: false,						// [행 번호 출력]
		viewrecords 	: true,							// [데이터 개수 표기]
		cellEdit 		: false,						// [셀 수정]
		cellsubmit 		: "clientArray",				// [셀 저장 방식] 	1) clientArray : 저장시 일괄 저장,     2) remote : 수정 시 바로 저장)
		multiselect 	: true,							// [체크 박스 노출 여부]
		height 			: "auto",
		initSearchYn	: "Y", 							// [초기 조회 값] 	1) Y : -> 초기 검색 O,   2) N : -> 초기검색 X
		initCondition	: {}, 							// [초기 조회 조건]
		initSearch		: {}, 							// [초기 조회 조건]
		autowidth   	: true,
		shrinkToFit 	: false,
		isPage			: true,							// [페이지 유무]    1) true : 페이지 O,     2) false : 페이지 없음
		multiGrid		: false,						// 한 화면에 다중 그리드 여부 1) true : 다중 그리드,  2) false : 하나의 그리드
		sortname		: "",							// [초기 정렬 컬럼]
		sortorder       : "",							// [초기 정렬 순서 DESC, ASC]
//		sortable		: true,
//		loadonce 		: true,
		pginput 		: false,						// [페이징 input 입력 유무]
		navOptions: {
            add: false, del: false, edit: false, search: false, refresh: false
        },

        // 셀 클릭 이벤트
        onCellSelect	: function(rowId) {

		},

		// 셀 더블 클릭 이벤트
		ondblClickRow	: function (rowId, iRow, iCol) {

		},

		// 그리드 호출 후 이벤트
		gridComplete : function() {

		},

		loadComplete : function(data) {

		},
        // 페이지 이동 전 이벤트 - 전체 페이지보다 높은 페이지로 이동시 마지막 페이지로 이동
        onPaging : function() {
        	var movePage	= _$pager.find(".ui-pg-input").val();
        	var totPage 	= _$pager.find(".ui-pg-input").next("span").text();

        	if (movePage > totPage) {
        		_$pager.find(".ui-pg-input").val(totPage)
        	}
        }
	}

	var _initDefault = {
		url				: "",							// [★필수★] [호출 url]
		colNames 		: [],							// [★필수★] [컬럼 이름]
		colModel 		: [],							// [★필수★] [컬럼 속성]
		datatype 		: "local",
		rowNum			: 30,							// [페이지 당 데이터 row 수]
		rowList			: [10, 30, 50, 70],				// [row 수 선택 select box 값]
		pager			: _getPager(),					// [페이징]
		caption	 		: "",
		rownumbers 		: false,						// [행 번호 출력]
		viewrecords 	: true,							// [데이터 개수 표기]
		cellEdit 		: false,						// [셀 수정]
		cellsubmit 		: "clientArray",				// [셀 저장 방식] 	1) clientArray : 저장시 일괄 저장,     2) remote : 수정 시 바로 저장)
		multiselect 	: true,							// [체크 박스 노출 여부]
		height 			: "auto",
		initSearchYn	: "Y", 							// [초기 조회 값] 	1) Y : -> 초기 검색 O,   2) N : -> 초기검색 X
		initCondition	: {}, 							// [초기 조회 조건]
		initSearch		: {}, 							// [초기 조회 조건]
		autowidth   	: true,
		shrinkToFit 	: false,
		isPage			: true,							// [페이지 유무]    1) true : 페이지 O,     2) false : 페이지 없음
		multiGrid		: false,						// 한 화면에 다중 그리드 여부 1) true : 다중 그리드,  2) false : 하나의 그리드
		sortname		: "",							// [초기 정렬 컬럼]
		sortorder       : "",							// [초기 정렬 순서 DESC, ASC]
//		sortable		: true,
//		loadonce 		: true,
		pginput 		: false,						// [페이징 input 입력 유무]
		navOptions: {
            add: false, del: false, edit: false, search: false, refresh: false
        },

        // 셀 클릭 이벤트
        onCellSelect	: function(rowId) {

		},

		// 셀 더블 클릭 이벤트
		ondblClickRow	: function (rowId, iRow, iCol) {

		},

		// 그리드 호출 후 이벤트
		gridComplete : function() {
		},

		loadComplete : function(data) {

		},

        // 페이지 이동 전 이벤트 - 전체 페이지보다 높은 페이지로 이동시 마지막 페이지로 이동
        onPaging : function() {
        	var movePage	= _$pager.find(".ui-pg-input").val();
        	var totPage 	= _$pager.find(".ui-pg-input").next("span").text();

        	if (movePage > totPage) {
        		_$pager.find(".ui-pg-input").val(totPage)
        	}
        }
	}

	var _getInitDefault = function() {
		return _initDefault;
	}

	var _getDefault = function() {
		return _default;
	}

	// jqgrid 옵션 설정 ( 기본설정 + 사용자 지정 옵션 extend)
	var _setDefault = function(options) {
		_default = $.extend({}, _default, options);
	}

	// jqgrid 옵션 가져오기
	var _getDefault = function() {
		return _default;
	}

	// 데이터 로드 후 실행 되는 함수
	var _eLoadComplete = {};

	
	
	// jqgrid 시작 메서드
	var _init = function(gridId, pageId, options, loadComplete) {

		// 탭 안에서의 페이지 이동으로 인한 옵션 초기화
		_setDefault(_initDefault);

		// 옵션 저장
		_setDefault(options);

		// 데이터 로드 후 실행 되는 함수 초기화
		_eLoadComplete = {};

		if (typeof loadComplete === "function") {
			_eLoadComplete = loadComplete;
		}

		var grid = "grid";

		// 화면에 멀티 그리드일 경우
		if (_default.multiGrid) {
			grid = _default.grid;

			_default.multiGrid = false;
		}

		_$grid = $("#" + gridId); ;
		_$pager = $("#" + pageId);

		_default.pager = _$pager;

		// 초기 jqgrid 그리기
		_$grid.jqGrid(_default).jqGrid("navGrid", _$pager);
	/*	_$grid.jqGrid(_default).jqGrid('sortableRows');
*/
		
		// grid 초기 사이즈를 위한 강제 resize
		$(window).trigger("resize");

		return {grid : _$grid, pager : _$pager};
	}

	// 데이터 조회
	var _search = function(condition, callback) {

		console.dir("setGrid"+_$grid);
		
		_$grid.setGridParam({
			page			: 1,
			datatype		: "json",
			mtype         	: "POST",
			postData		: {"param" : JSON.stringify(condition)}
		}).trigger("reloadGrid");
	}
	

	return {
		setGrid			: _setGrid,
		getGrid			: _getGrid,
		setPager		: _setPager,
		getPager		: _getPager,
		init			: _init,
		search			: _search
	}

}());

