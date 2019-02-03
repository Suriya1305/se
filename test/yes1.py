# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re

class AppDynamicsJob(unittest.TestCase):
    def setUp(self):
        # AppDynamics will automatically override this web driver
        # as documented in https://docs.appdynamics.com/display/PRO44/Write+Your+First+Script
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "https://www.katalon.com/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_app_dynamics_job(self):
        driver = self.driver
        driver.get("http://localhost:4200/welcome")
        driver.find_element_by_xpath("(.//*[normalize-space(text()) and normalize-space(.)='I'])[1]/following::span[1]").click()
        driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/following::span[1]").click()
        driver.find_element_by_id("mat-input-2").click()
        driver.find_element_by_id("mat-input-2").clear()
        driver.find_element_by_id("mat-input-2").send_keys("suriya@gmail.com")
        driver.find_element_by_id("mat-input-3").click()
        driver.find_element_by_id("mat-input-3").clear()
        driver.find_element_by_id("mat-input-3").send_keys("11111111")
        driver.find_element_by_xpath("//mat-select[@id='mat-select-0']/div/div/span").click()
        driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='เด็กหญิง'])[1]/following::span[1]").click()
        driver.find_element_by_id("mat-input-4").click()
        driver.find_element_by_id("mat-input-4").clear()
        driver.find_element_by_id("mat-input-4").send_keys("suriya siangsai")
        driver.find_element_by_xpath("//mat-select[@id='mat-select-1']/div/div/span").click()
        driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='หน้าแรก'])[1]/following::span[1]").click()
        driver.find_element_by_id("mat-input-5").click()
        driver.find_element_by_id("mat-input-5").clear()
        driver.find_element_by_id("mat-input-5").send_keys("0987654321")
        driver.find_element_by_id("mat-input-6").click()
        driver.find_element_by_id("mat-input-6").clear()
        driver.find_element_by_id("mat-input-6").send_keys("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
        driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]").click()
        self.assertEqual(u"บันทึกเรียบร้อย", driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='บันทึกเรียบร้อย'])[1]/following::span[1]").text)
        driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='บันทึกเรียบร้อย'])[2]/following::span[1]").click()
        driver.find_element_by_id("mat-input-7").clear()
        driver.find_element_by_id("mat-input-7").send_keys("suriya@gmail.com")
        driver.find_element_by_id("mat-input-8").clear()
        driver.find_element_by_id("mat-input-8").send_keys("11111111")
        driver.find_element_by_xpath(u"(.//*[normalize-space(text()) and normalize-space(.)='ล้าง'])[1]/preceding::span[1]").click()
        self.assertEqual(u"ยินดีต้อนรับ นายsuriya siangsai", driver.find_element_by_xpath("(.//*[normalize-space(text()) and normalize-space(.)='I'])[1]/following::span[1]").text)
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException as e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException as e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        # To know more about the difference between verify and assert,
        # visit https://www.seleniumhq.org/docs/06_test_design_considerations.jsp#validating-results
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
