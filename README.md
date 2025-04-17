# Project Overview

This repository contains two main modules:

1. **Petstore API**  
   Location: [`petstore-api/README.md`](petstore-api/README.md)  
   - A RESTful API implementation following the Swagger Petstore specification.
   - Includes source code, documentation, and integration tests.

2. **Monefy Android Test Automation**  
   Location: [`monefy-android-test-automation/README.md`](monefy-android-test-automation/README.md)  
   - End-to-end test suite for the Monefy mobile application using Kotlin, JUnit 5, and Appium.
   - Includes setup instructions, sample tests, and Docker integration.

---

## Repository Structure

```
.
├── petstore-api/
│   └── README.md                  # Petstore API module documentation
│   └── src/                       # API source code
│   └── tests/                     # Integration tests for Petstore API
├── monefy-android-test-automation/
│   └── README.md                  # Monefy automation module documentation
│   └── apps/                      # APK files
│   └── src/                       # Test code (Kotlin & utilities)
│   └── Dockerfile                 # Container setup for tests
└── README.md                      # This root overview (you are here)
```

---

## Getting Started

1. **Navigate to a module**  
   ```bash
   cd petstore-api
   # or
   cd monefy-android-test-automation
   ```

2. **Follow the instructions in that module's README**  

---

Feel free to explore each module independently or integrate into your CI/CD pipeline as needed.
