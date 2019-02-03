package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Y {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testY() throws Exception {
    driver.get("http://localhost:4200/welcome");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/following::span[1]")).click();
    driver.findElement(By.id("mat-input-2")).click();
    driver.findElement(By.id("mat-input-2")).clear();
    driver.findElement(By.id("mat-input-2")).sendKeys("suriya@gmail.com");
    driver.findElement(By.id("mat-input-3")).click();
    driver.findElement(By.id("mat-input-3")).clear();
    driver.findElement(By.id("mat-input-3")).sendKeys("11111111");
    driver.findElement(By.xpath("//mat-select[@id='mat-select-0']/div/div/span")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='เด็กหญิง'])[1]/following::span[1]")).click();
    driver.findElement(By.id("mat-input-4")).click();
    driver.findElement(By.id("mat-input-4")).clear();
    driver.findElement(By.id("mat-input-4")).sendKeys("suriya siangsai");
    driver.findElement(By.xpath("//mat-select[@id='mat-select-1']/div/div/span")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='หน้าแรก'])[1]/following::span[1]")).click();
    driver.findElement(By.id("mat-input-5")).click();
    driver.findElement(By.id("mat-input-5")).clear();
    driver.findElement(By.id("mat-input-5")).sendKeys("0987654321");
    driver.findElement(By.id("mat-input-6")).click();
    driver.findElement(By.id("mat-input-6")).clear();
    driver.findElement(By.id("mat-input-6")).sendKeys("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]")).click();
    assertEquals("บันทึกเรียบร้อย", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='บันทึกเรียบร้อย'])[1]/following::span[1]")).getText());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='บันทึกเรียบร้อย'])[2]/following::span[1]")).click();
    driver.findElement(By.id("mat-input-7")).clear();
    driver.findElement(By.id("mat-input-7")).sendKeys("suriya@gmail.com");
    driver.findElement(By.id("mat-input-8")).clear();
    driver.findElement(By.id("mat-input-8")).sendKeys("11111111");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]")).click();
    assertEquals("ยินดีต้อนรับ นายsuriya siangsai", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I'])[1]/following::span[1]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
