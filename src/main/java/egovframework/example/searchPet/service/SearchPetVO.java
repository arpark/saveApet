package egovframework.example.searchPet.service;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchPetVO {
	
	private String desertionNo;
	private String filename;
	private LocalDateTime happenDt;
	private String happenPlace;
	private String kindCd;
	private String kindDesc;
	private String noticeNo;
	private LocalDateTime noticeSdt;
	private String popfile;
	private String processState;
	private String processStateCd;
	private String sexCd;
	private String specialMark;
	private String upkind_cd;
	private String kind_cd;
	private String upr_cd;
	private String org_cd;
	private String care_reg_no;
	private String latitude;
	private String longitude;
	private String careAddr;
	private String careNm;
	private String careTel;
	private String colorCd;
	private String neuterYn;
	private String weight;
	private String age;

}
