package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.BaseClass;

import javax.activation.DataSource;
import javax.print.DocFlavor;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

       String repName;

          public void onStart(ITestContext testContext){

              /*
              SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
              Date dt=new Date();
              String currentdatetimestamp=df.format(dt);
               */

              String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
              repName="Test-Report-"+ timeStamp + ".html";

           sparkReporter=new ExtentSparkReporter(".\\Reports\\" + repName);
         sparkReporter.config().setDocumentTitle("opencart Automation Report");
         sparkReporter.config().setReportName("opencart Functional Testing");
         sparkReporter.config().setTheme(Theme.DARK);

            extentReports =new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Application","opencart");
            extentReports.setSystemInfo("Module","Admin");
            extentReports.setSystemInfo("Sub Module","Customers");
              extentReports.setSystemInfo("User Name",System.getProperty("user.name"));
              extentReports.setSystemInfo("Environment","QA");

                String os= testContext.getCurrentXmlTest().getParameter("os");
                extentReports.setSystemInfo("Operating System",os);
                String browser=testContext.getCurrentXmlTest().getParameter("browser");
                extentReports.setSystemInfo("Browser",browser);
              List<String> includeGroups= testContext.getCurrentXmlTest().getIncludedGroups();
              if(! includeGroups.isEmpty())
              {
                  extentReports.setSystemInfo("Groups",includeGroups.toString());
              }
          }

             public void  onTestSuccess(ITestResult result)
             {
              extentTest=extentReports.createTest(result.getTestClass().getName());
               extentTest.assignCategory(result.getMethod().getGroups());
               extentTest.log(Status.PASS,result.getName()+"got successfully executed");
             }


       public void onTestFailure(ITestResult result){
           extentTest=extentReports.createTest(result.getTestClass().getName());
           extentTest.assignCategory(result.getMethod().getGroups());
           extentTest.log(Status.FAIL,result.getName()+"got failed");
           extentTest.log(Status.INFO,result.getThrowable().getMessage());

           try {
                String imgPath=new BaseClass().captureScreen(result.getName());
                extentTest.addScreenCaptureFromPath(imgPath);
           }
           catch (IOException e1)
           {
               e1.printStackTrace();
           }
       }
       public void onTestSkipped(ITestResult result){
             extentTest=extentReports.createTest(result.getTestClass().getName());
             extentTest.assignCategory(result.getMethod().getGroups());
             extentTest.log(Status.SKIP,result.getName()+"got skipped");
             extentTest.log(Status.INFO,result.getThrowable().getMessage());

       }
         public void onFinish(ITestContext testContext){
              extentReports.flush();
              String pathOfExtentReport=System.getProperty("user.dir")+"\\Reports\\"+repName;
             File extentReport=new File(pathOfExtentReport);
             try {
                 Desktop.getDesktop().browse(extentReport.toURI());
             }
             catch (IOException e) {
                e.printStackTrace();
             }

            /*
             try {
                 URL url=new URL("file:////"+System.getProperty("user.dir")+"\\Reprts\\"+repName);
                 ImageHtmlEmail email=new ImageHtmlEmail();
                 email.setDataSourceResolver(new DataSourceUrlResolver(url));
                 email.setHostName("smtp.googlemail.com");
                 email.setSmtpPort(465);
                 email.setAuthenticator(new DefaultAuthenticator("javeedzyan92@gmail.com","password"));
                 email.setSSLOnConnect(true);
                 email.setFrom("javeedzyan92@gmail.com");
                 email.setSubject("Test Result");
                 email.setMsg("please find attach Report.....");
                 email.addTo("jabedabu31@gmail.com");
                 email.attach(url,"extent report","please check report....");
                 email.send();
             }
             catch (Exception e){
                 e.printStackTrace();
             }

             */
             }
         }

