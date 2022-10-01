const fs = require("fs");
const path = require("path");
const { createStorage } = require("./storage");

exports.createDatabase = (databaseDir, storages, initializers) => {
  const isDirectory = fs.existsSync(databaseDir);

  if (!isDirectory) {
    fs.mkdirSync(databaseDir);
  }

  const getPath = (storage) => `${storage}.json`;

  storages.forEach((storage, index) => {
    const filePath = getPath(storage);
    const isFile = fs.existsSync(path.join(databaseDir, filePath));

    if (!isFile) {
      fs.writeFileSync(
        path.join(databaseDir, filePath),
        JSON.stringify(initializers[index])
      );
    }
  });

  return storages.reduce((acc, storageName) => {
    return {
      ...acc,
      [storageName]: createStorage(databaseDir, getPath(storageName)),
    };
  }, {});
};
