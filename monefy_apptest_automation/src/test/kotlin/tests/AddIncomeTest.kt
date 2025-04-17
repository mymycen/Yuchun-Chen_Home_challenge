package tests

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.*
import utils.DriverFactory
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddIncomeTest {
    private lateinit var driver: AndroidDriver

    @BeforeAll
    fun setup() {
        driver = DriverFactory.createDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }

    @Test
    fun completedAddIncomeFlow() {
        // Accept onboarding screens
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonClose")).click()

        // Perform add income flow
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/income_button")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard5")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard0")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/keyboard_action_button")).click()

        // Select category
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.monefy.app.lite:id/imageView'])[1]")).click()
      
        // Assert balance is updated
        val balance = driver.findElement(AppiumBy.id("com.monefy.app.lite:id/balance_amount")).text
        Assertions.assertTrue(balance.contains("50"))
    }

    @AfterAll
    fun teardown() {
        driver.quit()
    }
}
