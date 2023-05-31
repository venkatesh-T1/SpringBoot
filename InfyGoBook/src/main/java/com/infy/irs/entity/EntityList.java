package com.infy.irs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({UserEntity.class})
public class EntityList<T> implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> list;
	
	public EntityList() {
	list= new ArrayList<>();
	}
	public EntityList(List<T> list) {
		super();
		this.list=list;
	}
	@XmlAnyElement
	public List<T> getItems(){
		return this.list;
	}
	
}
