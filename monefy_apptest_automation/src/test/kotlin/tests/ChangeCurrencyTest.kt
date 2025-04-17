package tests

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.*
import utils.DriverFactory
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChangeCurrencyTest {
    private lateinit var driver: AndroidDriver

    @BeforeAll
    fun setup() {
        driver = DriverFactory.createDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }

    @Test
    fun changeCurrencyFlow() {
        // Accept onboarding
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonClose")).click()

        // Click navigation drawer
        driver.findElement(AppiumBy.accessibilityId("Settings")).click()

        // Click Settings
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/settings_imagebutton")).click()

        // Click on Currency option
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Currency']")).click()


       // scroll until an element with text “EUR” is visible
       driver.findElement(
       AppiumBy.androidUIAutomator(
       "new UiScrollable(new UiSelector().scrollable(true))" +
       ".scrollIntoView(new UiSelector().text(\"EUR\"));"
       )).click()

        // Select EUR
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='EUR']")).click()
        // Go back
        driver.navigate().back()
        driver.navigate().back()

        // Validate currency symbol changed
        val balanceText = driver.findElement(AppiumBy.id("com.monefy.app.lite:id/balance_amount")).text
        Assertions.assertTrue(balanceText.contains("€"))
    }

    @AfterAll
    fun teardown() {
        driver.quit()
    }
}
