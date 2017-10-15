package com.uptotech.server_tutor.dao;

import java.util.ArrayList;

import com.uptotech.server_tutor.model.EnglishCategory;
import com.uptotech.server_tutor.model.EnglishWord;

public interface TestDAO {
	ArrayList<EnglishWord> getInstances();
	ArrayList<EnglishWord> getWordInstances(int categoryId);
	ArrayList<EnglishCategory> getCategoryInstances();
}
