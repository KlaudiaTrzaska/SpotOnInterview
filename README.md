# Spot On - interview assigment Klaudia Białczyk

### Assignment

> For the second assessment, we would like you to create a test plan to cover the Shopping Cart, and the Check Out process on the web application below. You do not need to create step by step instructions, just the scenarios you are going to test, and then automate the 5 scenarios outlined below.

Demo Site:  http://automationpractice.com/index.php

Please automate the following scenarios
- Search for and view a shirt using the search bar
    - [SearchingItemsTest.java](test/SearchingItemsTest.java)
- Add a shirt and a dress to the cart and continue to the checkout section.  Change the shirt quantity to 2 and remove the dress   
    - [SecondTest.java](test/SecondTest.java)
- Compare the features of two clothing items
    - [CompareItemsTest.java](test/CompareItemsTest.java)
- Navigate to the Bestsellers section and sort by highest to lowest price
    - Bestsellers section does not support sorting!
- Navigate to the Contact Us section and send a message.  Check form validation.
    - [ContactUsTest.java](test/ContactUsTest.java)

### Tech stack
Technical interview project using:
- JAVA 
- MAVEN 
- SELENIUM 
- JUNIT

####Folder Structure:
Test directory has all the necessary sub folders and tests within it.
````
test/pages: contains the classes for the pages
test/controls: contains the UI elements like button, text box to which you can pass the selector and value and get the webelement as the return object.
test/utils: contains the data model objects
````
####To use this follow the below steps
1. Clone the repo
2. Run the following command from the project folder
```
mvn compile
```
```
mvn test
```

The pom.xml has dependencies for chromedriver, htmluntidriver and pantomjs. These drivers can be used by changing the driver instance creation. To run on chrome:
 ```
 mvn test -Dwebdriver.chrome.driver=/path/to/chromedriver
 ```   
