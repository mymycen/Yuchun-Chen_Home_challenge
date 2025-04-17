package utils

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.time.Duration

object DriverFactory {
    fun createDriver(): AndroidDriver {
        val caps = DesiredCapabilities()
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/monefy.apk")
        caps.setCapability("appWaitActivity", "*")

        return AndroidDriver(URL("http://127.0.0.1:4723/wd/hub"), caps)
    }
}
