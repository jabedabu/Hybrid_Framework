package testBase;

import org.apache.commons.lang3.RandomStringUtils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
   public static WebDriver driver;
   public Logger logger;
  public Properties properties;


    @BeforeClass(groups = {"Sanity","Regression","Master"})
    @Parameters({"os","browser"})
    public void setUP(String os,String br) throws IOException {


       FileReader fileReader=new FileReader(".\\src\\test\\resources\\config.properties");
        properties=new Properties();
        properties.load(fileReader);

       logger=LogManager.getLogger(this.getClass());

          if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
          {
              DesiredCapabilities capabilities=new DesiredCapabilities();
               //os
              if(os.equalsIgnoreCase("windows"))
              {
                  capabilities.setPlatform(Platform.WIN11);
              }
              else if(os.equalsIgnoreCase("linux"))
              {
                  capabilities.setPlatform(Platform.LINUX);
              }
              else if(os.equalsIgnoreCase("mac")){
                  capabilities.setPlatform(Platform.MAC);
              }
              else {
                  System.out.println("No matching os");
                  return;
              }
              //browser
              switch (br.toLowerCase())
              {
                  case "chrome":capabilities.setBrowserName("chrome");break;
                  case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
                  case "firefox":capabilities.setBrowserName("firefox");break;
                  default:System.out.println("No matching browser");return;
              }
              driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
          }

          if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
          {
              switch (br.toLowerCase())
              {
                  case "chrome": driver=new ChromeDriver();  break;
                  case "edge": driver=new EdgeDriver();break;
                  case "firefox":driver=new FirefoxDriver();break;
                  default:System.out.println("Invalid browser name..");return;

              }
          }




        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

      driver.get(properties.getProperty("appURL2"));

      //driver.get(properties.getProperty("appURL1"));

        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity","Regression","Master"})

    public void tearDown(){
        driver.quit();
    }

    //this RandomStringUtils i have to add commons.lang3 depedency...
    public String randomString() {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return generateString;

    }

    public String randomNumber() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;

    }

    public String randomAlphaNumeric() {
        String generateString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return (generateString + "@" + generatedNumber);
    }

    public String captureScreen(String tname)throws IOException{

        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timeStamp+".png";
        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;

           }

}