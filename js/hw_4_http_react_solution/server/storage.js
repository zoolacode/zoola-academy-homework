const fs = require("fs");

const storageFilePath = require("path").join(__dirname, "storage.json");

exports.write = (data) => {
  fs.writeFileSync(storageFilePath, JSON.stringify(data, null, 2));
};

exports.read = () => {
  const data = fs.readFileSync(storageFilePath).toString();
  return JSON.parse(data);
};
