package fr.co.mybus.mrn.common.core.web;

//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author neerajsi
 *
 */
public class MRNJson 
{
	
	String status;
	String error;
	String warning;
	String info;
	Object data;
	Object field;
	
//	@JsonProperty("Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//@JsonProperty("Error")
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	//@JsonProperty("Warning")
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	//@JsonProperty("Info")
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	//@JsonProperty("Data")
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
//	@JsonProperty("Field")
	public Object getField() {
		return field;
	}
	public void setField(Object field) {
		this.field = field;
	}
	
	
	
	
	
	
	
	
}
