# Monefy Android Test Automation

This repository contains an end-to-end (E2E) test suite for the Monefy Android application, built with Kotlin, JUnit 5, Appium, and Gradle. It also includes a Dockerfile to containerize the test execution environment.

## 🚀 Project Overview

- **Language & Frameworks**: Kotlin, JUnit 5  
- **Automation**: Appium with UiAutomator2  
- **Build System**: Gradle Kotlin DSL  
- **Containerization**: Docker  

### Key User Flows Covered
1. Accept onboarding/introduction screens  
2. Add an expense and verify balance update  
3. Add income and verify balance update  
4. Change currency and verify symbol update  

---

## 📥 Setup & Installation

### Prerequisites (local)
- macOS/Linux with x86_64 or ARM64 support  
- Android Studio (to manage SDK & AVD)  
- Java JDK 19  
- Node.js & npm  
- Gradle Wrapper (`./gradlew` comes bundled)  

#### 1. Clone this repo

```bash
git clone https://github.com/mymycen/Yuchun-Chen_Home_challenge.git
cd monefy_apptest_automation
```

#### 2. Install Android SDK components

```bash
# Set your SDK root
export ANDROID_SDK_ROOT=~/Library/Android/sdk
export PATH=$PATH:$ANDROID_SDK_ROOT/emulator:$ANDROID_SDK_ROOT/platform-tools

# Install system image and tools if needed
sdkmanager "platform-tools" "platforms;android-30" "emulator" "system-images;android-30;google_apis;x86_64"
```

#### 3. Install Appium globally

```bash
npm install -g appium
```

#### 4. Prepare the emulator

```bash
# Create (if not existing) and start an AVD
avdmanager create avd -n testAVD -k "system-images;android-30;google_apis;x86_64" --force
emulator -avd testAVD &
adb devices  # should list emulator-5554
```

---

## ▶️ Running Tests Locally

1. **Start Appium server**  
   ```bash
   appium --base-path /wd/hub
   ```

2. **Run Gradle tests**  
   ```bash
   ./gradlew clean test
   ```

3. **View the HTML report**  
   ```bash
   open /Users/yuchunchen/Workspace/Yuchun-Chen_Home_Challenge/monefy_apptest_automation/build/reports/tests/test/packages/tests.html
   ```

---

## 🐳 Dockerized Execution

The included Dockerfile builds an image that includes:
- Java 19  
- Android SDK command‑line tools, emulator, and a headless AVD  
- Appium server  
- Gradle wrapper and project sources  

### Build the Docker image

```bash
docker build -t monefy-test .
```

> **Note**: Docker requires `--privileged` to run the Android emulator.

### Run tests inside Docker

```bash
docker run --rm --privileged monefy-test
```

This command will:  
1. Launch the Android emulator (headless)  
2. Start Appium with `/wd/hub` base path  
3. Execute `./gradlew test`  
4. Print logs and exit  

---

## 🗂️ Project Structure

```
├── apps/
│   └── monefy.apk         # APK under test
├── src/
│   ├── main/              # (empty; all code under test)
│   └── test/
│       ├── kotlin/tests/  # E2E test classes
│       └── kotlin/utils/  # DriverFactory
├── build.gradle.kts       # Gradle Kotlin DSL
├── Dockerfile             # Container definition
└── README.md              # This file
```

---

## 📖 Approach & Tech Stack

- **Modular, maintainable code**: Tests use a `DriverFactory` to encapsulate Appium setup and teardown.  
- **Explicit waits & safe clicks**: Custom helpers using `WebDriverWait` and retry loops to avoid flakiness.  
- **Containerization**: Dockerfile automates environment provisioning for CI/CD pipelines.

