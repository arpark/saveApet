<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
	$(".navigation > li").removeClass("active");
	
	if("${naviId}" != "")
	$("#" + "${naviId}").addClass("active");

});
</script>
<div id="header">
	<div class="clearfix">
		<div class="logo">
			<a href="${ctx}/main.do"><img src="${ctx}/images/saveApet.png" alt="LOGO" height="52" width="362" /></a>
		</div>
		<ul class="navigation">
			<li id="saveapetInfo"><a href="${ctx}/saveapetInfo.do">saveApet 소개</a></li>
			<li id="searchPet"><a href="${ctx}/searchPet/main.do">유기동물 검색</a></li>
			<li id="petReSystem"><a href="${ctx}/petReSystemMain.do">반려동물등록제</a></li>
			<li id="animalPro"><a href="${ctx}/animalProMain.do">동물호보센터 안내</a></li>
		</ul>
	</div>
</div>