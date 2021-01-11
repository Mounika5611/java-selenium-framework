This Custom Selenium Framework is mainly using Java, Selenium, TestNG. Basically it opens up any given browser and navigates to Amazon signin page and enter the valid credentials and logs in and checks whether it is logged in correctly. It also returns the results of the tests.

SETUP:
-Used maven for Build Management
-Used Page Object Model(POM) as design pattern
-Used Log4J for logs 
-Used Allure for reporting

HOW TO RUN THE TESTS ON CHROME:
-Clone the project
-Download the respective chrome driver and browser.
-Do 'mvn clean install'
-You would see the tests running already
-To test the positive case leave the credentials as is in the config file
-To test the negative case try changing the values in the config file
