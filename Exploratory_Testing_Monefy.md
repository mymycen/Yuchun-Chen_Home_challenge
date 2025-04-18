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

1. **Subscription & Restore Logic**  
   - **Bug**: “Restore” button is non‑functional and re‑installed subscriptions aren’t skipped.  
   - **Mitigation**: Implement automated end‑to‑end regression tests covering:
     - First‑run with no subscription
     - First‑run with existing subscription
     - Restore‑flow twice in a row  
     Ensure hooks in the purchase‑restore API are stubbed/mocked in CI to validate both success and failure responses.

2. **UI Overlay & Readability**  
   - **Bug**: Transaction messages overlap background content; sort colors fallen back to grey.  
   - **Mitigation**: Add visual‑regression tests (e.g. screenshot comparisons) for:
     - Adding a transaction
     - Sorting lists  
     Incorporate a “contrast checker” into CI that flags overlapping or low‑contrast UI elements.

3. **Category & Budget Integrity**  
   - **Bug**: Pie chart omits older categories; merge action deletes the wrong category and mislabels success.  
   - **Mitigation**:  
     - Write data‑driven tests that:
       1. Create multiple categories
       2. Merge pairs in different orders  
       3. Verify both the retained category and merge message text  
     - Add a contract test against the backend to ensure all categories (not just latest) are fetched and represented.

4. **Localization Consistency**  
   - **Bug**: Balance text remains in previous language after switching locale.  
   - **Mitigation**:  
     - Automate locale‑switch tests covering each supported language.  
     - Integrate a continuous l10n‑audit step using tools like **i18n-check** to find untranslated or stale strings.
     - Add a smoke test after changing language that asserts all key labels (balance, button texts) update correctly.

5. **Data Sync & State Accuracy**  
   - **Bug**: Balance view doesn’t reflect updated settings; silent sync failures risk data loss.  
   - **Mitigation**:  
     - Implement integration tests that:
       - Toggle offline/online states
       - Perform updates on two simulated devices  
       - Assert conflict‑resolution policies and user notifications are exercised.  
     - Surface sync errors via in‑app banners or logs, and monitor them in CI (e.g. fail build if any uncaught sync‑error code appears).

6. **Usability & Navigation Depth**  
   - **Minor**: Deleting requires navigating two levels.  
   - **Mitigation**: Add exploratory and automated UI workflows to measure “tap depth” for critical actions—flag anything > 2 taps as an ergonomic risk for further UX review.

7. **Crash & Performance Monitoring**  
   - **Mitigation**:  
     - Integrate a crash‑reporting SDK (e.g. Crashlytics) to catch silent failures (like the keypad overlay bug).  
     - Add performance‑profiling tests for startup, chart rendering, and list sorting to detect regressions early.

---

