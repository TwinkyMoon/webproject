package com.uptotech.server_tutor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENGLISHCATEGORY")
public class EnglishCategory implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -6076586667357322614L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "NAME_EN", nullable = false)
	public String nameEn;

	@Column(name = "NAME_RU", nullable = false)
	public String nameRu;

	public EnglishCategory() {

	}

	public EnglishCategory(int id, String nameEn, String nameRu) {
		this.id = id;
		this.nameEn = nameEn;
		this.nameRu = nameRu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameRu() {
		return nameRu;
	}

	public void setNameRu(String nameRu) {
		this.nameRu = nameRu;
	}

	@Override
	public String toString() {
		return "EnglishCategory [" + nameEn + " = " + nameRu + "]";
	}

}
