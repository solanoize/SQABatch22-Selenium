package com.juaracoding.test.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.test.DriverSingleton;

public class SignInTest {

  WebElement usernameField;
  WebElement passwordField;
  WebElement buttonLogin;

  @BeforeTest
  public void setup() {

  }

  @Test(priority = 1)
  public void negativeSignInWithoutCredential() throws InterruptedException {
    System.out.println(1);

    Thread.sleep(2000);
  }

  @Test(priority = 2)
  @Parameters({ "password" })
  public void negativeSignInWithoutUsername(String password) throws InterruptedException {
    System.out.println(2);

    Thread.sleep(2000);
  }

  @Test(priority = 3)
  @Parameters({ "username" })
  public void negativeSignInWithoutPassword(String username) throws InterruptedException {
    System.out.println(3);

    Thread.sleep(2000);
  }

  // @Test(priority = 4, enabled = false)
  // @Parameters({"username", "password", "expectedSignIn"})
  // public void happySignInTest(String username, String password, String
  // expectedSignIn) {
  // System.out.println(4);

  // typeUsername(username);
  // typePassword(password);
  // clickButton();
  // String urlDirectionActual =
  // DriverSingleton.createOrGetDriver().getCurrentUrl();

  // Assert.assertEquals(
  // urlDirectionActual,
  // expectedSignIn,
  // "Halaman tidak redirect ke inventory!"
  // );
  // }
}
