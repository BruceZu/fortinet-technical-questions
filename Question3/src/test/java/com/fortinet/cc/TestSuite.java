package com.fortinet.cc;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.fortinet.cc.question3.FindKGroupsTest;

@RunWith(Suite.class)
@SuiteClasses({FindKGroupsTest.class})
public class TestSuite {
	
	public static void main(String[] args) throws Exception {                    
	       JUnitCore.main("com.fortinet.cc.TestSuite");            
	}

}
