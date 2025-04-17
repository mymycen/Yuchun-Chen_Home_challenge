const axios = require("axios");

const apiClient = axios.create({
  baseURL: "http://localhost:3001",
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  }
});

module.exports = apiClient;
