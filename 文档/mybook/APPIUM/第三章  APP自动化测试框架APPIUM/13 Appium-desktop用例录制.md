

Appium-desktop用例录制

- 使用appium desktop录制用例

- 安装python依赖 pip install Appium-Python-Client

- 增加隐式等待增强稳定性（可以查看在官方文档查看隐式等待相关方法）

  ## [appium](https://github.com/appium/appium)/[docs](https://github.com/appium/appium/tree/master/docs)/[en](https://github.com/appium/appium/tree/master/docs/en)/[commands](https://github.com/appium/appium/tree/master/docs/en/commands)/[session](https://github.com/appium/appium/tree/master/docs/en/commands/session)/[timeouts](https://github.com/appium/appium/tree/master/docs/en/commands/session/timeouts)/**implicit-wait.md**

  Appium github地址：

  https://github.com/appium/appium

  driver.implicitly_wait(10)：只要不超时，就会循环查找某个元素

- 重新运行

  **自动为应用赋值权限**：autoGrantPermissions    true or false

  **adb 连接逍遥模拟器**：

  - 开启模拟器后，在命令行输入：adb connect 127.0.0.1:21503，如果显示connected to 127.0.0.1:21503则表示连接成功。

  python代码示例：

  ```python
  #coding=utf-8
  # This sample code uses the Appium python client
  # pip install Appium-Python-Client
  # Then you can paste this into a file and simply run with Python
  
  from appium import webdriver
  
  caps = {}
  caps["platformName"] = "Android"
  caps["deviceName"] = "模拟器"
  caps["appPackage"] = "com.oppo.usercenter"
  caps["appActivity"] = ".vip.UCVIPMainActivity"
  caps["noReset"] = "True"
  
  driver = webdriver.Remote("http://localhost:4723/wd/hub", caps)
  driver.implicitly_wait(10)
  el1 = driver.find_element_by_id("com.oppo.usercenter:id/cb_sign_in")
  el1.click()
  el2 = driver.find_element_by_id("com.oppo.usercenter:id/tv_sign")
  el2.click()
  driver.quit()
  ```

  java代码示例：

  ```java
  import io.appium.java_client.MobileElement;
  import io.appium.java_client.android.AndroidDriver;
  import junit.framework.TestCase;
  import org.junit.After;
  import org.junit.Before;
  import org.junit.Test;
  import java.net.MalformedURLException;
  import java.net.URL;
  import org.openqa.selenium.remote.DesiredCapabilities;
  
  public class SampleTest {
  
    private AndroidDriver driver;
  
    @Before
    public void setUp() throws MalformedURLException {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setCapability("platformName", "Android");
      desiredCapabilities.setCapability("deviceName", "模拟器");
      desiredCapabilities.setCapability("appPackage", "com.oppo.usercenter");
      desiredCapabilities.setCapability("appActivity", ".vip.UCVIPMainActivity");
      desiredCapabilities.setCapability("noReset", "True");
  
      URL remoteUrl = new URL("http://localhost:4723/wd/hub");
  
      driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }
  
    @Test
    public void sampleTest() {
      MobileElement el1 = (MobileElement) driver.findElementById("com.oppo.usercenter:id/cb_sign_in");
      el1.click();
      MobileElement el2 = (MobileElement) driver.findElementById("com.oppo.usercenter:id/tv_sign");
      el2.click();
    }
  
    @After
    public void tearDown() {
      driver.quit();
    }
  }
  
  ```

  