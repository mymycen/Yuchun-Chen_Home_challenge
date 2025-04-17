# Exploratory Testing Session: Monefy iOS Application

## 1. Exploratory Testing Charters

| Charter ID | Charter Title                       | Scope & Goals                                                                      |
|------------|--------------------------------------|------------------------------------------------------------------------------------|
| C1         | Onboarding & First-Run Experience   | Validate the onboarding flow, account setup prompts, and first-run tutorial screens.|
| C2         | Adding and Viewing Transactions     | Test adding, editing, and deleting expenses/income; verify transaction list UI.     |
| C3         | Budget and Category Management      | Explore category selection, budget creation, and category-wise reports.             |
| C4         | Currency and Localization Settings  | Verify currency switch, region-based formats, and localization strings.             |
| C5         | Data Persistence & Sync             | Check data persistence after app restart and sync behavior if connected to cloud.   |

## 2. Findings

### C1: Onboarding & First-Run Experience
- **What Worked**: Welcome screens display correctly; “Get Started” and “Skip” buttons function.
- **Issues Found**:
  - **Bug**: “Terms and Conditions” link opens blank modal (iOS 14.6).  
  - **Minor UX**: “Skip” button text truncates on smaller devices.
  
### C2: Adding and Viewing Transactions
- **What Worked**: Adding expense/income is quick; transaction list updates immediately.
- **Issues Found**:
  - **Bug**: Numeric keypad overlay occasionally fails to dismiss after entry.
  - **Bug**: Deleting a transaction shows confirmation twice.

### C3: Budget and Category Management
- **What Worked**: Default categories available; budget graph renders correctly.
- **Issues Found**:
  - **Bug**: Creating a new category crashes app if category name is > 20 characters.
  - **Minor**: Category icons overlap text on landscape orientation.

### C4: Currency and Localization Settings
- **What Worked**: Currency switch updates symbol app-wide; date formats respect locale.
- **Issues Found**:
  - **Bug**: Switching to Japanese Yen resets budget values to zero.
  - **Minor**: Some labels remain in English when locale is French.

### C5: Data Persistence & Sync
- **What Worked**: Transactions persist between restarts; offline mode stores new entries.
- **Issues Found**:
  - **Bug**: Sync fails silently when network restores; no user notification.
  - **Risk**: Data conflict if same entry edited on two devices.

## 3. Prioritisation of Charters

| Charter ID | Priority | Reason                                                           |
|------------|----------|------------------------------------------------------------------|
| C5         | High     | Data loss or incorrect sync impacts core user trust and finances.|
| C2         | High     | Transaction handling is primary app function.                    |
| C3         | Medium   | Budget/category errors affect analytics but not core entry.      |
| C4         | Medium   | Localization bugs impact international users' clarity.           |
| C1         | Low      | Onboarding issues affect first-run but not ongoing usage.        |

## 4. Risk Mitigation

1. **Data Integrity**  
   - Implement robust conflict resolution and user notifications on sync errors.  
   - Add data backup prompts before major edits or category changes.
2. **UI Stability**  
   - Add automated UI tests for orientation changes and long text inputs.  
   - Enforce constraints on input lengths in UI fields.
3. **Localization Coverage**  
   - Integrate a translation-proofing process with native speakers.  
   - Automate locale-specific UI scans to catch untranslated strings.
4. **Performance & Crash Monitoring**  
   - Include crash-reporting (e.g., Crashlytics) to capture exceptions like keypad overlay.  
   - Monitor app launch times and memory usage on various iOS versions.
5. **Security & Privacy**  
   - Ensure all data at rest/in transit is encrypted.  
   - Prompt for biometric authentication before showing sensitive financial summaries.
