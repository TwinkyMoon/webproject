package com.uptotech.server_tutor.web.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uptotech.server_tutor.model.*;
import com.uptotech.server_tutor.service.TestService;

@RestController
public class MyRestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<EnglishWord>> sayHelloAgain() {
		ArrayList<EnglishWord> list = testService.getInstances();
		return new ResponseEntity<List<EnglishWord>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/get", params = {"categoryId"}, method = RequestMethod.GET)
	public ResponseEntity<List<EnglishWord>> getWordsOnCategory(@RequestParam(value = "categoryId") int categoryId) {
		ArrayList<EnglishWord> list = testService.getWordInstances(categoryId);
		return new ResponseEntity<List<EnglishWord>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/1", method = RequestMethod.GET)
	public ResponseEntity<EnglishWord> sayHelloAgain2() {
		ArrayList<EnglishWord> list = testService.getInstances();
		return new ResponseEntity<EnglishWord>(list.get(0), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCategories", method = RequestMethod.GET)
	public ResponseEntity<List<EnglishCategory>> getCategories() {
		ArrayList<EnglishCategory> list = testService.getCategoryInstances();
		return new ResponseEntity<List<EnglishCategory>>(list, HttpStatus.OK);
	}

}
