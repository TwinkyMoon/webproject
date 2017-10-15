package com.uptotech.server_tutor.web.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uptotech.server_tutor.model.EnglishWord;
import com.uptotech.server_tutor.service.TestService;

@Controller
public class BaseController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "push 15");
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addtest(ModelMap model) {
		ArrayList<EnglishWord> list = testService.getInstances();
		ResponseEntity temp = new ResponseEntity<List<EnglishWord>>(list, HttpStatus.OK);
		model.addAttribute("greeting", temp.getBody());
		return "index";
	}

}
