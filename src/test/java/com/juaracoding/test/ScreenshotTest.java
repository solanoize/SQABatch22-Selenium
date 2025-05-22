package com.juaracoding.test;

import org.testng.annotations.Test;
import org.testng.Assert;

public class ScreenshotTest extends BaseTest {

  @Test
  public void testOpenExampleDotCom() {

    // Simpel cek title saja
    String title = driver.getTitle();
    // Assert.assertTrue(title.contains("Example Domain"));

    // Ambil screenshot dan simpan dengan nama file unik
    takeScreenshot("example_com_test.png");
  }
}
