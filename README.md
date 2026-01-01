# rukkor-chat-automation
Automation testing for chat application using Selenium, TestNG, and Page Object Model.
# Chat Automation Testing Framework

## Overview
This project automates a web-based chat application using Selenium WebDriver,
TestNG, and Java. It covers core chat functionalities such as message sending,
editing, and sender-side deletion across multiple browser sessions.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## Framework Design
- Page Object Model (POM)
- Explicit waits for synchronization
- Multi-browser support (Chrome & Firefox)
- TestNG for test execution

## Features Automated
- User login (OTP handled manually)
- Send message (User A → User B)
- Edit message (Sender only)
- Delete message (Visible only to sender)
- Receiver-side message validation

## Prerequisites
- Java 17 or above
- Maven installed
- Chrome and Firefox browsers
- Stable internet connection

## Execution Steps
1. Clone the repository or extract the zip file
2. Open the project in STS / IntelliJ / Eclipse
3. Update `testng.xml` if needed
4. Run the test using:
   - Right click on `testng.xml` → Run as TestNG Suite
   - OR run test class directly

## Notes
- OTP is entered manually during execution
- Reaction automation is implemented but not executed by default
  due to dynamic UI rendering

## Author
Sudhanshu
