package com.dsumtsov.spring.testing;

import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(WildcardPatternSuite.class)
@SuiteClasses({UnitTestsSuite.class, IntegrationTestsSuite.class})
public class AllTestsSuite {
}
