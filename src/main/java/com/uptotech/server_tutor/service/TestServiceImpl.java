package com.uptotech.server_tutor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uptotech.server_tutor.dao.TestDAO;
import com.uptotech.server_tutor.model.EnglishCategory;
import com.uptotech.server_tutor.model.EnglishWord;

@Component(value = "testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDAO testDAO;

	public ArrayList<EnglishWord> getInstances() {
		return testDAO.getInstances();
	}

	public ArrayList<EnglishCategory> getCategoryInstances() {
		return testDAO.getCategoryInstances();
	}

	public ArrayList<EnglishWord> getWordInstances(int categoryId) {
		// TODO Auto-generated method stub
		return testDAO.getWordInstances(categoryId);
	}
}
