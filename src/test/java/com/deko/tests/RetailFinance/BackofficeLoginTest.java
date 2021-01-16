package com.deko.tests.RetailFinance;

import com.deko.testing.robot.backoffice.BackofficeRobot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BackofficeLoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void testTearDown(){
        driver.close();
    }

    @AfterSuite
    public void suiteTearDown(){
        driver.quit();
    }

    @Test
    public void backOfficeLoginPageLoadSuccess(){
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot
                .openBackofficeLoginPage()
                .verifyBackofficeUrl();

        Assert.assertTrue(robot.verifyBackofficeUrl());
    }

    //todo: Write the rest of the tests for the backoffice login page here.
    //todo: Chrome driver should spin up, pass all tests identified (unless you find a bug?) and quit.

    @Test
    public void test() {
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot.fillLoginUsername("Taiwo.Onipede");
    }

    @Test
    public void test2() {
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot.fillLoginPassword("DekoQA2020");
    }

    @Test
    public void test3() {
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot.submitLoginForm();
    }

    @Test
    public void test4() {
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot.verifySuccessfulLogin("Taiwo's Dashboard");
    }
}
