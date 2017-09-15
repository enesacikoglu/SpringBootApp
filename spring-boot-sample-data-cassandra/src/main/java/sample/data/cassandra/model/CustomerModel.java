package sample.data.cassandra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class CustomerModel {

	private String id;

	@JsonProperty("DT_RowId")
	private String dtRowid;
	
	private String firstName;

	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getDtRowid() {
		return dtRowid;
	}

	public void setDtRowid(String dtRowid) {
		this.dtRowid = dtRowid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
		
}
