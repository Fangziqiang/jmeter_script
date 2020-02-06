## 长按/滑动等TouchAction应用

手势操作TouchAction

```python
from appium.webdriver.common.touch_action import TouchAction
actions=TouchAction(driver)
actions.tap(element)
actions.perform()
```

![1580562110597](..\appium_img\1580562110597.png)

long_press 长按

release  释放

swipe封装