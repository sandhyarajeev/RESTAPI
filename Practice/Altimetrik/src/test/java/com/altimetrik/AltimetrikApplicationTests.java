package com.altimetrik;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.springframework.test.context.ContextConfiguration;

@Suite
@ContextConfiguration
@SuiteDisplayName("Test Suite")
@SelectPackages({"com.altimetrik.service",
		"com.altimetrik.controller",
		"com.altimetrik"
		})
class AltimetrikApplicationTests {


}
