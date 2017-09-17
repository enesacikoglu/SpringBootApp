package sample.data.cassandra.xml.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@XmlRootElement(name = "rows")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList {
	
	private List<ProductType> row;

	public List<ProductType> getRowsList() {
		if (row==null) {
			row=new ArrayList<>();		
			}
		return row;
	}

	public void setRowsList(List<ProductType> row) {
		this.row = row;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
