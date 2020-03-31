$(function() {
	
	//모든 datepicker에 대한 공통 옵션 설정
    $.datepicker.setDefaults({
    	dateFormat: 'yy-mm-dd' //Input Display Format 변경
		,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
	    ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
		,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
		,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
		,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
		,changeMonth: true
		,changeYear: true
    });
	
	$("#s_date").datepicker();
	$("#e_date").datepicker();

});

//시도 -> 시군구 코드 조회
function uprCdChange(uprCd) {

    var orgHtml = "";
    $("#selectOrgCd").find("option").remove();
    orgHtml = "<option value=''>전체</option>";
    
    if(uprCd != ""){
    	
    	$.ajax({
    		async : false,
			type    : "POST",
			url     : "/saveApet/searchPet/getCode.do",
			dataType 	: "json",
			data    : { "first_code" : uprCd, "groupCode" : "1"},
			success : function(reData) {
				var data = reData.data;
				
				if (data.status == "SUCCESS") {
					var list = data.codeList;

					for(var i in list){
						orgHtml += "<option value='" + list[i].code + "'>" + list[i].code_desc +"</option>"
					}
					   
				} else {
					alert("에러가 발생했습니다. 관리자에게 문의해주세요.2");
				}
			},
			error   : function(){
				alert("에러가 발생했습니다. 관리자에게 문의해주세요.1");
			}
		});
    }
    
    $("#selectOrgCd").append(orgHtml);
}

//시도 , 시군구 -> 보호소 코드 조회
function orgCdChange(uprCd,orgCd,selectBoxId) {

	var $selectBoxId =  $("#"+ selectBoxId);
	
    var careHtml = "";
	$selectBoxId.find("option").remove();
	careHtml = "<option value=''>전체</option>";
    
    if(uprCd != "" && orgCd != ""){
    	
    	$.ajax({
    		async : false,
			type    : "POST",
			url     : "/saveApet/searchPet/getCode.do",
			dataType 	: "json",
			data    : { "first_code" : uprCd, "second_code" : orgCd, "groupCode" : "2"},
			success : function(reData) {
				var data = reData.data;
				
				if (data.status == "SUCCESS") {
					var list = data.codeList;

					for(var i in list){
						careHtml += "<option value='" + list[i].code + "'>" + list[i].code_desc +"</option>"
					}
					   
				} else {
					alert("에러가 발생했습니다. 관리자에게 문의해주세요.2");
				}
			},
			error   : function(){
				alert("에러가 발생했습니다. 관리자에게 문의해주세요.1");
			}
		});
    } else {
    	alert("상위코드를 선택해주세요.");
    	
    }
    
    $selectBoxId.append(careHtml);
}


function imgPopup(url) {
	window.open(url,'_blank','960','720','menubars=no','scrollbars=auto');
}


