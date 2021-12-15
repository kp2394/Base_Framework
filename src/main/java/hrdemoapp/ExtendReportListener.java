package hrdemoapp;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExtendReportListener implements IReporter{
	//create ExtendReports object;
	private ExtendReports extend;
	//This method creates the report and iterates over the list of ISuites
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>, suites, String outputDirectory) {
		extend = new ExtendReports(outputDirectory + File.separator + "OutputExtendReport.html", true);
		for(ISuite testSuite:suites) {
			Map<String, ISuiteResult>testResult = testSuite.getResults();
			
			for (ISuiteResult r : testResult.values()) {
				ITestContext testContext = r.getTestContext();
				
				//invoke the buildTestNodes to send data to the report
				buildTestNodes(testContext.getPassedTests(),LogStatus.PASS);
				buildTestNodes(testContext.getFailedTests(),LogStatus.FAIL);
				buildTestNodes(testContext.getSkippedTests(),LogStatus.SKIP);
			}
		}
		//send the data to the report
		extend.flush();
		extend.close();
	}
	
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtendTest test;
		if(tests.size() > 0) {
			for(ITestResult result : tests.getAllResults()) {
				test = extend.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for(String group : result.getMethod().getGroups())
					test.assignCategory(group);
				
				if(result.getThrowable()!=null) {
					test.log(status, result.getThrowable());
				}else {
					test.log(status, "Test has" + status.toString().toLowerCase() + "ed");
				}
				
				extend.endTest(test);
			}	
		}
	}
	//Get the Current time stamp
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

}
