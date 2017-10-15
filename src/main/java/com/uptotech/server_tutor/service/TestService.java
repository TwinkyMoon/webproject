package com.uptotech.server_tutor.service;

import java.util.ArrayList;

import com.uptotech.server_tutor.model.EnglishCategory;
import com.uptotech.server_tutor.model.EnglishWord;

public interface TestService {
	ArrayList<EnglishWord> getInstances();
	ArrayList<EnglishWord> getWordInstances(int categoryId);
	ArrayList<EnglishCategory> getCategoryInstances();
}
