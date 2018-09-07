package fr.co.mybus.mrn.common.core.db;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class ComboList extends JdbcDaoSupport 
{
	String selected;
	
	List comboList;
	
	String selectedValue;
	
	public String getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected() {
		this.selected = "selected";
	}

	public List getComboList() {
		return comboList;
	}

	public void setComboList(List comboList) {
		this.comboList = comboList;
	}
	
	

}
