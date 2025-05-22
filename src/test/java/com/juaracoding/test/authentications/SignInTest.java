package com.juaracoding.test.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.test.DriverSingleton;

public class SignInTest {

  WebElement usernameField;
  WebElement passwordField;
  WebElement buttonLogin;

  public void clickButton() {
    buttonLogin.click();
  }

  public void typeUsername(String username) {
    usernameField.sendKeys(username);
  }

  public void clearUsername() {
    usernameField.clear();
  }

  public void submitUsername() {
    usernameField.submit();
  }

  public void typePassword(String password) {
    passwordField.sendKeys(password);
  }

  public void clearPassword() {
    passwordField.clear();
  }

  public void submitPassword() {
    passwordField.submit();
  }

  @BeforeTest
  public void setup() {
    System.out.println(0);
  }

  @BeforeMethod() 
  public void init() throws InterruptedException {
    Thread.sleep(2000);
    System.out.println("INI DARI KELAS SIGINTEST SEBELUM TEST METHOD: " + DriverSingleton.createOrGetDriver().getCurrentUrl());
    usernameField = DriverSingleton.createOrGetDriver().findElement(By.xpath("//*[@data-test=\"username\"]"));
    passwordField = DriverSingleton.createOrGetDriver().findElement(By.xpath("//*[@id=\"password\"]"));
    buttonLogin = DriverSingleton.createOrGetDriver().findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/input[3]"));
  }

  @Test(priority = 1)
  public void negativeSignInWithoutCredential() throws InterruptedException {
    System.out.println(1);
    clickButton();
    Thread.sleep(2000);
  }

  @Test(priority = 2)
  @Parameters({"password"})
  public void negativeSignInWithoutUsername(String password) throws InterruptedException {
    System.out.println(2);
    typePassword(password);
    submitPassword();
    clearPassword();
    Thread.sleep(2000);
  }

  @Test(priority = 3)
  @Parameters({"username"})
  public void negativeSignInWithoutPassword(String username) throws InterruptedException {
    System.out.println(3);
    typeUsername(username);
    submitUsername();
    clearUsername();
    Thread.sleep(2000);
  }

  // @Test(priority = 4, enabled = false)
  // @Parameters({"username", "password", "expectedSignIn"})
  // public void happySignInTest(String username, String password, String expectedSignIn) {
  //   System.out.println(4);

  //   typeUsername(username);
  //   typePassword(password);
  //   clickButton();
  //   String urlDirectionActual = DriverSingleton.createOrGetDriver().getCurrentUrl();
    
  //   Assert.assertEquals(
  //     urlDirectionActual, 
  //     expectedSignIn, 
  //     "Halaman tidak redirect ke inventory!"
  //   );
  // }
}
