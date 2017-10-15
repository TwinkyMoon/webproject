package com.uptotech.server_tutor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENGLISHWORDS")
public class EnglishWord implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = -6076586667357321614L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "WORDEN", nullable = false)
	public String wordEn;

	@Column(name = "WORDRU", nullable = false)
	public String wordRu;

	@Column(name = "CATEGORY_ID", nullable = false)
	public int categoryId;

	public EnglishWord() {

	}

	public EnglishWord(int id, String wordEn, String wordRu, int categoryId) {
		this.id = id;
		this.wordEn = wordEn;
		this.wordRu = wordRu;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWordEn() {
		return wordEn;
	}

	public void setWordEn(String wordEn) {
		this.wordEn = wordEn;
	}

	public String getWordRu() {
		return wordRu;
	}

	public void setWordRu(String wordRu) {
		this.wordRu = wordRu;
	}

	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "EnglishWord + " + categoryId + " [" + wordEn + " = " + wordRu + "]";
	}

}
