# Simple Cucumber Test Samples

##### Here are two code samples for the basic cucumber BDD test.
1. _Hello_ example.
2. _Selenium_ example.

##### Run selenium test under headless browser in Linux
1. Install X-Virtual Frame Buffer.
```
$sudo apt-get install xvfb
```
2. Run X-virtual Frame Buffer in background.
Display the xvfb in _number 99_ server. Default display is using _number 0_ server.
```
$Xvfb :99 -ac &
```
3. Change the DISPLAY to xvfb and run the test cases
```
// 1) change to xvfb display
$export DISPLAY=:99
// 2) run the test. It will not open the browser, it just run under xvfb.
$mvn test
```
###### Environment
+ OS: Linux Mint 18 (amd64) - 4.4.0-21-generic
+ Java: 1.6.0_45
+ Firefox: 27.0
+ Maven: 3.2.5
+ Selenium: 2.41.0

#References:
Selenium:<http://www.seleniumhq.org/docs/03_webdriver.jsp>