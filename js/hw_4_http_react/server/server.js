const express = require("express");
const storage = require("./storage");

const app = express();

const scoreBoardApp = express();

scoreBoardApp.use(express.json());

scoreBoardApp.post("/chat", (req, res) => {
  const data = storage.read();
  const nextData = [...data, req.body];
  storage.write(nextData);
  res.send(nextData);
});

scoreBoardApp.get("/chat", (_, res) => {
  const data = storage.read();
  res.send(data);
});

app.use("/api", scoreBoardApp);

app.listen(4000, () => {
  console.log("Listening on port 4000");
});

export const date = Date.now()
