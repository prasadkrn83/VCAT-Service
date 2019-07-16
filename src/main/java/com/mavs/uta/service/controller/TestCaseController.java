package com.mavs.uta.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavs.uta.service.bean.TestCaseRequest;
import com.mavs.uta.service.codegenerator.SeleniumConstants;
import com.mavs.uta.service.codegenerator.TestScriptSource;
import com.mavs.uta.service.codegenerator.TestScriptSourceUtility;

@RestController
@RequestMapping(path = "/vcat")
public class TestCaseController {
	
	
	@PostMapping(value="/testcase",consumes="application/json", produces = "application/json")
	public String generateTestCase(@RequestBody TestCaseRequest testCaseRequest) {
		String sourceFileName=SeleniumConstants.TESTCASE_NAME;
		String sourcePackage=SeleniumConstants.TESTCASE_BASE_PACKAGE;
		String URL=testCaseRequest.getUrl();
		System.out.println(testCaseRequest.toString());
		TestScriptSource source;
		try {
			source =  TestScriptSourceUtility.createTestScriptSourceFile(sourceFileName, sourcePackage, URL,testCaseRequest.getElements());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return source.getSourceAsString().toString();
	}

}
