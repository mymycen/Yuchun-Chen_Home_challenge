# Exploratory Testing Session: Monefy iOS Application

## 1. Exploratory Testing Charters

| Charter ID | Charter Title                      | Scope & Goals                                                                        |
| ---------- | ---------------------------------- | ------------------------------------------------------------------------------------ |
| C1         | Onboarding & First-Run Experience  | Validate the onboarding flow, account setup prompts, and first-run tutorial screens. |
| C2         | Adding and Viewing Transactions    | Test adding, editing, and deleting expenses/income; verify transaction list UI.      |
| C3         | Budget and Category Management     | Explore category selection, budget creation, and category-wise reports.              |
| C4         | Currency and Localization Settings | Verify currency switch, region-based formats, and localization strings.              |
| C5         | Data Persistence & Sync            | Check data persistence after app restart and sync behavior if connected to cloud.    |

## 2. Findings

### C1: Onboarding & First-Run Experience
- **What Worked**: Welcome screens display correctly; “Get Started”, “Amazing”,“I'm ready” buttons function.
- **Issues Found**:
  - **Bug**: 1. “Restore” has no function (iOS 18.1.1). 
  - **Bug**: 2. If the payment has been subscribed before and reinstall app second time and it still able to continue with payment instead of skip it.  
  
### C2: Adding and Viewing Transactions
- **What Worked**: Adding expense/income is quick; transaction list updates immediately.
- **Issues Found**:
  - **Bug**: 1. Adding transaction message (number) overlap on background text due to display background is not grayout and it make user difficult to read info.
  - **Bug**: 2. In transaction list - When sort by date, all the numbers shows grey instead of red/green.  
  - **Minor improvement**: User needs to go 2 levels of transactions and view the single transaction to delete the transactions instead of transaction view.

### C3: Budget and Category Management
- **What Worked**: Default categories available; Piechart shows the percentage correctly.
- **Issues Found**:
  - **Bug**: The category pie indications does not reflect all the categories which has expense/income. It only reflects latest ones and it's not consistant.
  - **Minor improvement**: User choose to merge the category and it always delete the one user is and merge to the one user choose. There is no option to choose which to keep or rename to new one directly by merging action. Also after merge, it shows backup success message instead of merge succeed and it's misleading user.

### C4: Currency and Localization Settings
- **What Worked**: Currency switch updates symbol app-wide; date formats respect locale.
- **Issues Found**:
  - **Bug**: Balance view remains in English(previous lanaguage) when locale updates Chinese. (or other languages)

### C5: Data Persistence & Sync
- **What Worked**: Transactions persist between restarts; offline mode stores new entries.
- **Issues Found**:
  - **Bug**: The balance view is not updated after update settings.
  - **Risk**: Data conflict if same entry edited on two devices.

## 3. Prioritisation of Charters

| Charter ID | Priority | Reason                                                            |
| ---------- | -------- | ----------------------------------------------------------------- |
| C5         | High     | Data loss or incorrect sync impacts core user trust and finances. |
| C2         | High     | Transaction handling is primary app function.                     |
| C3         | Medium   | Budget/category errors affect analytics but not core entry.       |
| C4         | Medium   | Localization bugs impact international users' clarity.            |
| C1         | Low      | Onboarding issues affect first-run but not ongoing usage.         |

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
