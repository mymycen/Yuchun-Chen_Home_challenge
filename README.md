# Project Overview

This repository contains two main modules:

1. **Petstore API**  
   Location: [`petstore-api-tests/README.md`](petstore-api-tests/README.md)  
   - A RESTful API implementation following the Swagger Petstore specification.
   - Includes source code, documentation, and integration tests.

2. **Monefy Android Test Automation**  
   Location: [`monefy_apptest_automation/README.md`](monefy_apptest_automation/README.md)  
   - End-to-end test suite for the Monefy mobile application using Kotlin, JUnit 5, and Appium.
   - Includes setup instructions, sample tests, and Docker integration.

---

## Repository Structure

```
.
├── petstore-api-tests/
│   └── README.md                  # Petstore API module documentation
│   └── src/                       # API source code
│   └── tests/                     # Integration tests for Petstore API
|   └── Dockerfile                 # Container setup for tests
├── monefy_apptest_automation/
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
   cd petstore-api-tests
   # or
   cd monefy_apptest_automation
   ```

2. **Follow the instructions in that module's README**  

---

Feel free to explore each module independently or integrate into your CI/CD pipeline as needed.
