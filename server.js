const express = require("express");

const fs = require("fs");

const app = express();

app.get('/files/:filename', (req, res) => {
  
    const filePath = `./files/${req.params.filename}`;

  const fileStream = fs.createReadStream(filePath);

  fileStream.pipe(res);
});

const port = 3000;

app.listen(port, () => {
  console.log(`Listening on port ${port} woohoo!`);
});