const http = require("http");

http
  .createServer((req, res) => {
    if (req.url === "/hello") {
      res.write(JSON.stringify({ name: "Hello World" }));
      res.end();
      return;
    }

    if (req.url?.startsWith("/email")) {
      res.write(JSON.stringify({ name: "Email created" }));
      res.end();
    }
  })
  .listen(8000, () => {
    console.log("Listening on port 8000");
  });
