package com.juaracoding.test.authentications;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.test.DriverSingleton;

public class SignInWithoutCredential {
  WebElement buttonLogin;
  WebElement usernameField;
  WebDriver driver;
  List<String> missingElements = new ArrayList<>();
  boolean skipClass = false;

  // Helper untuk cek dan catat elemen
  private WebElement checkAndGet(WebDriverWait wait, String name, By locator) {
    try {
      return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    } catch (TimeoutException e) {
      missingElements.add(name);
      return null;
    }
  }

  @BeforeClass
  public void setup() {
    driver = DriverSingleton.createOrGetDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    buttonLogin = checkAndGet(wait, "buttonLogin", By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"));
    usernameField = checkAndGet(wait, "usernameField", By.xpath("//*[@data-test=\"usernames\"]"));

    if (!missingElements.isEmpty()) {
      skipClass = true;
    }
  }

  @BeforeMethod
  public void checkElementsExist() {
    if (skipClass) {
      throw new SkipException("No element found: " + String.join(", ", missingElements));
    }
  }

  @Test
  public void testStep03() {
    usernameField.sendKeys("hello");
    buttonLogin.click();
  }
}
