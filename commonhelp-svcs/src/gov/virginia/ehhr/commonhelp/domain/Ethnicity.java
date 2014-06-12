package gov.virginia.ehhr.commonhelp.domain;

import java.io.Serializable;

public class Ethnicity implements Serializable {

	private static final long serialVersionUID = 3717892413733569711L;
	
	private Boolean mexican;
	private Boolean mexicanAmerican;
	private Boolean chicano;
	private Boolean puertoRican;
	private Boolean cuban;
	
	public Boolean getMexican() {
		return mexican;
	}
	public void setMexican(Boolean mexican) {
		this.mexican = mexican;
	}
	public Boolean getMexicanAmerican() {
		return mexicanAmerican;
	}
	public void setMexicanAmerican(Boolean mexicanAmerican) {
		this.mexicanAmerican = mexicanAmerican;
	}
	public Boolean getChicano() {
		return chicano;
	}
	public void setChicano(Boolean chicano) {
		this.chicano = chicano;
	}
	public Boolean getPuertoRican() {
		return puertoRican;
	}
	public void setPuertoRican(Boolean puertoRican) {
		this.puertoRican = puertoRican;
	}
	public Boolean getCuban() {
		return cuban;
	}
	public void setCuban(Boolean cuban) {
		this.cuban = cuban;
	}
	
	

}
