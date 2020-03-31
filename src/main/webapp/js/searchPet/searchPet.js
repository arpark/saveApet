$(function() {
	searchPetList(1,{});
})

function petSearchBtnClick(){
	
	var param = $("#searchFrm").serializeObject();
	
	console.dir(param)
	//selectUprCd=&selectOrgCd=0000000&s_up_kind_cd=&processState=
	searchPetList(1, param)
}

function searchPetList(pageno,param) {
	$("#petListUl").find("li").remove();
	
	param.pageno = pageno;
	$.ajax({
		async : false,
		type    : "POST",
		url     : "/saveApet/searchPet/getPetList.do",
		dataType 	: "json",
		data    : param,
		success : function(reData) {
			console.log(reData)
			
			if (reData.status == "SUCCESS") {
				printPetList(reData);
			} else {
				alert("에러가 발생했습니다. 관리자에게 문의해주세요.2");
			}
		},
		error   : function(){
			alert("에러가 발생했습니다. 관리자에게 문의해주세요.1");
		}
	});
}


function printPetList(data) {
	
	var petList = data.petList;
	
	var i = 0;
	var html = '';
	
	for (var cnt = 0; cnt < petList.length; cnt) {
		var pet = petList[cnt];
		
		if (i == 2) {
			i = 0;
		
		} else {

			html += '<li class="first">'
			html += '	<div class="photo">'
            html += '        <div class="thumbnail">'
            html += '            <a target="_blank" title="클릭시 새창이 열립니다." onclick="imgPopup(' + pet.popfile + ')" onkeypress="this.onclick(); return false;">'
            html += '            	<img src="' + pet.filename + '" alt="보호중동물사진 공고번호-"' + pet.notionNo + '">'
            html += '            </a>'
            html += '        </div>'
            html += '        <button class="moreBtn">자세히보기</button>'
            html += '    </div>'
            html += '    <div class="txt">'
            html += '       		<dl><dt>공고번호</dt><dd>' + pet.noticeNo + '</dd></dl>'
			html += '	        <dl><dt>접수일자</dt><dd>' + pet.noticeSdt + '</dd></dl>'
			html += '	        <dl><dt>품종</dt><dd>' + pet.kindCd + '</dd></dl>'
			
			if (pet.sexCd == 'M') {
				html += '<dl><dt>성별</dt><dd>수컷</dd></dl>'
			} else {
				html += '<dl><dt>성별</dt><dd>암컷</dd></dl>'
			}
			
			html += '	        <dl><dt>발견장소</dt><dd>' + pet.happenPlace + '</dd></dl>'
			html += '	        <dl><dt>특징</dt><dd>' + pet.specialMark + '</dd></dl>'
			html += '	        <dl><dt>상태</dt><dd>' + pet.processState + '</dd></dl>'
            html += '    </div>'
            html += '</li>'
		
            i++, cnt++;
		}
	}

	$("#petListUl").append(html);
	
	// 검색결과 표시
	$("#paging").html(data.page);
	$("#search_total").text(data.count);
	
	
}