package com.juaracoding.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

/*
 * test conflict
 */
/*
 * ini Tata
/**
 * Ini komentar (yanwar)
 */

/**
 * Ayam goreng kalasan.
 */
public class BaseTest {
  WebDriver driver;

  /*
   * halloo (tambah author pake extensi mas haha biar tau siapa yang push)
   */
  @BeforeClass
  public void setup() {
    driver = DriverSingleton.createOrGetDriver();
  }
}
