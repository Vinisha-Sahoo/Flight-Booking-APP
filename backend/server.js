const express = require("express");
const bodyParser = require("body-parser");
const fs = require("fs");
const cors = require("cors");
const path = require("path");

const app = express();
const PORT = 8082;

app.use(cors());
app.use(bodyParser.json());

// Serve frontend files
app.use(express.static(path.join(__dirname, "../public")));

const USERS_FILE = path.join(__dirname, "users.json");

// Read users
function readUsers() {
  if (!fs.existsSync(USERS_FILE)) return [];
  const data = fs.readFileSync(USERS_FILE);
  return JSON.parse(data || "[]");
}

// Write users
function writeUsers(users) {
  fs.writeFileSync(USERS_FILE, JSON.stringify(users, null, 2));
}

// SIGN UP
app.post("/signup", (req, res) => {
  const { fullName, email, phone, password } = req.body;
  const users = readUsers();

  if (users.find((u) => u.email === email)) {
    return res.status(400).json({ message: "Email already exists" });
  }

  const newUser = { fullName, email, phone, password };
  users.push(newUser);
  writeUsers(users);

  res.json({ message: "Signup successful", user: newUser });
});

// SIGN IN
app.post("/signin", (req, res) => {
  const { email, password } = req.body;
  const users = readUsers();
  const user = users.find((u) => u.email === email && u.password === password);

  if (!user) {
    return res.status(401).json({ message: "Invalid email or password" });
  }

  res.json({ message: "Signin successful", user });
});

// Catch-all to serve index.html
app.get(/.*/, (req, res) => {
  res.sendFile(path.join(__dirname, "../public/index.html"));
});

app.listen(PORT, "0.0.0.0", () => {
  console.log(`✅ Server running at http://10.3.50.43:${PORT}/`);
});
