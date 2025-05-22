package com.juaracoding.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class BaseTest {
  protected WebDriver driver;

  @BeforeClass
  public void setup() {
    driver = DriverSingleton.createOrGetDriver();
  }

  /**
   * Method untuk mengambil screenshot, simpan ke path yang diberikan,
   * dan log ke report TestNG dengan link dan gambar thumbnail
   */
  protected void takeScreenshot(String fileName) {
    try {
      // Pastikan folder screenshots ada
      String screenshotDir = System.getProperty("user.dir") + "/screenshots";
      Files.createDirectories(Paths.get(screenshotDir));

      File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      String filePath = screenshotDir + "/" + fileName;
      File destFile = new File(filePath);

      FileUtils.copyFile(srcFile, destFile);

      // Log link dan gambar ke report
      Reporter.log("<a href='" + filePath + "' target='_blank'>Screenshot</a>");
      Reporter.log("<br><img src='" + filePath + "' height='200' width='200'/>");

    } catch (Exception e) {
      Reporter.log("Gagal mengambil screenshot: " + e.getMessage());
    }
  }
}
