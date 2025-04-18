# PET API Test Automation Framework

This project automates CRUD testing of the Swagger Petstore `/pet` endpoint using an in‑memory mock via **json-server**.

## 🚀 Quick Start

1. **Clone this repo**

```bash
git clone https://github.com/mymycen/Yuchun-Chen_Home_challenge.git
cd monefy_apptest_automation
```

2. **Install dependencies**

   ```bash
   npm install
   ```

3. **Run mock server + tests**
   ```bash
   npm test
   ```
   This script will:
   - Spin up `json-server` on `http://localhost:3001` (serving `db.json`)
   - Wait 1 second
   - Execute the Jest test suite against that mock API

## 🗂️ Project Structure

```
petstore-api-tests/
├── db.json                 # json-server database (initial pet data)
├── package.json            # dependencies & scripts
├── Dockerfile              # builds & runs mock + tests in one container
├── src/
│   ├── data/
│   │   └── petPayloads.js   # test payloads
│   ├── utils/
│   │   └── apiClient.js     # axios instance (baseURL http://localhost:3000)
│   └── tests/
│       └── pet.test.js      # CRUD tests (Jest)
└── README.md
```

## 📦 Scripts

- **`npm run mock`**  
  Starts the mock API:

  ```bash
  json-server --watch db.json --port 3001
  ```

- **`npm test`**  
  Runs the full flow:
  ```bash
  npm run mock & sleep 1 && jest --runInBand
  ```

## 🐳 Docker

1. **Build the image**

   ```bash
   docker build -t petstore-tests .
   ```

2. **Run the container**
   ```bash
   docker run --rm petstore-tests
   ```

This will automatically start the mock server and execute your tests in one go.
