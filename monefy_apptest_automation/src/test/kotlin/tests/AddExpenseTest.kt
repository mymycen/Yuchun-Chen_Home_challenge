package tests

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.*
import utils.DriverFactory
import java.time.Duration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddExpenseTest {
    private lateinit var driver: AndroidDriver

    @BeforeAll
    fun setup() {
        driver = DriverFactory.createDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }

    @Test
    fun completeAddExpenseFlow() {
        // Accept onboarding screens
        repeat(3) {
            driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonContinue")).click()
        }
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonClose")).click()

        // Add Expense
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/expense_button")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard4")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard0")).click()
        driver.findElement(AppiumBy.id("com.monefy.app.lite:id/keyboard_action_button")).click()
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.monefy.app.lite:id/imageView'])[3]")).click()

        val balance = driver.findElement(AppiumBy.id("com.monefy.app.lite:id/balance_amount")).text
        Assertions.assertTrue(balance.contains("-$40"))
    }

    @AfterAll
    fun teardown() {
        driver.quit()
    }
}
