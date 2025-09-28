# Selenium Checkout Automation

This project contains automated tests for verifying the checkout flow of a sample e-commerce application using **Selenium WebDriver** and **TestNG**.

## 📂 Project Structure
- `com.automation.pages` → Page Object classes (`LoginPage`, `ProductsPage`, `CheckoutPage`)
- `com.automation.tests` → Test classes (`CheckoutTest`)
- `com.automation.utils` → Utility classes (`DriverFactory`, `ConfigReader`)
- `testng.xml` → TestNG suite configuration

## 🚀 How to Run Tests

### Prerequisites
- Install Java (JDK 11 or above)
- Install TestNG
- Install Selenium WebDriver (or use WebDriverManager)
- Install Chrome/Firefox/Edge browser

### Run from IDE
1. Open the project in IntelliJ / Eclipse.
2. Right-click `CheckoutTest.java` → Run with TestNG.

### Run from Command Line
If using TestNG jar + Selenium jars:

```bash
javac -cp "libs/*;." com\automation\pages\*.java com\automation\tests\*.java com\automation\utils\*.java
java -cp "libs/*;." org.testng.TestNG testng.xml
