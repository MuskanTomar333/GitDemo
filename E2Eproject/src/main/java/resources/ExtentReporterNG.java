package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports reports;
public static ExtentReports getReportObject()
{
	ExtentSparkReporter html=new ExtentSparkReporter("./reports/index.html");
	html.config().setReportName("Web Automation Results");
	html.config().setDocumentTitle("Test Results");
	reports=new ExtentReports();
	reports.attachReporter(html);
	reports.setSystemInfo("Tester", "Muskan Tomar");
	return reports;
}
}
