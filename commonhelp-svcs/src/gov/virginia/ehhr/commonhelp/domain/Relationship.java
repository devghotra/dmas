package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Relationship implements Serializable{

	private static final long serialVersionUID = -1876596483094557015L;
	
	private String memberId;
	private String relationWithMemberId;
	private String relationCode;
	private String relation;
	private String memberGender;
	private static Map<String, String> maleRelations = new HashMap<String, String>();
	private static Map<String, String> femaleRelations = new HashMap<String, String>();
	
	static{
		 maleRelations.put("BTR" ,"is the Brother of");
		 maleRelations.put("FTR" ,"is the Father of");
		 maleRelations.put("GGF" ,"is the Grandfather (Including Great) of");
		 maleRelations.put("GGS" ,"is the Grandson (Including Great) of");
		 maleRelations.put("HUS" ,"is the Husband of");
		 maleRelations.put("SON" ,"is the Son of");
		 maleRelations.put("FCO" ,"is the First Cousin of");
		 maleRelations.put("FC" ,"is the First Cousin (Once removed) of");
		 maleRelations.put("FK" ,"is the Foster Child of");
		 maleRelations.put("FP" ,"is the Foster Parent of");
		 maleRelations.put("HBR" ,"is the Half Brother of");
		 maleRelations.put("LG" ,"is the Legal Guardian of");
		 maleRelations.put("LD" ,"is the Legally Guarded of");
		 maleRelations.put("LT" ,"is the Living Partner of");
		 maleRelations.put("NEP" ,"is the Nephew (Including Great) of");
		 maleRelations.put("PL" ,"is the Pending Legal Guardian of");
		 maleRelations.put("PD" ,"is the Pending Legally Guarded of");
		 maleRelations.put("PF" ,"is the Putative(alleged) Father of");
		 maleRelations.put("PS" ,"is the Putative(alleged) Son of");
		 maleRelations.put("STB" ,"is the Step Brother of");
		 maleRelations.put("STF" ,"is the Step Father of");
		 maleRelations.put("SG" ,"is the Step Grandfather (Including Great) of");
		 maleRelations.put("SR" ,"is the Step Grandson (Including Great) of");
		 maleRelations.put("STS" ,"is the Step Son of");
		 maleRelations.put("UNC" ,"is the Uncle (Including Great) of");
		 maleRelations.put("UR" ,"is in the Unrelated Court Ordered Placement of");
		 maleRelations.put("NOT" ,"is Not related to");
		 maleRelations.put("RT" ,"is Related to another way to");
		 maleRelations.put("BIL" ,"is Brother In Law of");
		 maleRelations.put("AS" ,"is Alien Sponsor of");
		 
		 
		 femaleRelations.put("DAU" ,"is the Daughter of");
		 femaleRelations.put("GRD" ,"is the Granddaughter (Including Great) of");
		 femaleRelations.put("GRM" ,"is the Grandmother (Including Great) of");
		 femaleRelations.put("MTR" ,"is the Mother of");
		 femaleRelations.put("STR" ,"is the Sister of");
		 femaleRelations.put("WIF" ,"is the Wife of");
		 femaleRelations.put("AUN" ,"is the Aunt (Including Great) of");
		 femaleRelations.put("FCO" ,"is the First Cousin of");
		 femaleRelations.put("FC" ,"is the First Cousin (Once removed) of");
		 femaleRelations.put("FK" ,"is the Foster Child of");
		 femaleRelations.put("FP" ,"is the Foster Parent of");
		 femaleRelations.put("HSR" ,"is the Half Sister of");
		 femaleRelations.put("LG" ,"is the Legal Guardian of");
		 femaleRelations.put("LD" ,"is the Legally Guarded of");
		 femaleRelations.put("LT" ,"is the Living Partner of");
		 femaleRelations.put("NIE" ,"is the Niece (Including Great) of");
		 femaleRelations.put("PL" ,"is the Pending Legal Guardian of");
		 femaleRelations.put("PD" ,"is the Pending Legally Guarded of");
		 femaleRelations.put("PU" ,"is the Putative(alleged) Daughter of");
		 femaleRelations.put("STD" ,"is the Step Daughter of");
		 femaleRelations.put("SH" ,"is the Step Granddaughter (Including Great) of");
		 femaleRelations.put("SX" ,"is the Step Grandmother (Including Great) of");
		 femaleRelations.put("STM" ,"is the Step Mother of");
		 femaleRelations.put("SSR" ,"is the Step Sister of");
		 femaleRelations.put("UR" ,"is in the Unrelated Court Ordered Placement of");
		 femaleRelations.put("NOT" ,"is Not related to");
		 femaleRelations.put("RT" ,"is Related to another way to");
		 femaleRelations.put("SIL" ,"is Sister In Law of");
		 femaleRelations.put("AS" ,"is Alien Sponsor of");
	}	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRelationWithMemberId() {
		return relationWithMemberId;
	}
	public void setRelationWithMemberId(String relationWithMemberId) {
		this.relationWithMemberId = relationWithMemberId;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getRelationCode() {
		return relationCode;
	}
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}
	public String getMemberGender() {
		
		if(memberGender != null && memberGender.equalsIgnoreCase("male"))
			this.relation = maleRelations.get(relationCode);
		else if(memberGender != null && memberGender.equalsIgnoreCase("female"))
			this.relation = femaleRelations.get(relationCode);
		
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	
	
	

}
