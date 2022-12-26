 
const fs = require('fs');
const express = require('express');
let app = express();
app.listen(3000, () => {
  console.log('Listening on port 3000');
});
 
app.get('/tasks', (req, res) => {
    fs.readFile('list.json',(err, content) => {
        if (err) {
            console.error(err);
            return;
        }
        res.send(`Your tasks are: ${content}`); 
    })
});
  
  app.get('/tasks/new',(req, res) => {
    let id = req.query.id || "<unknown>";
    let task = req.query.task || "<unknown>";
 
    fs.readFile('list.json',(err, content) => {
      if (err) {
          console.error(err);
          return;
      }
 
      input = JSON.parse(content);
      input.list.push({
        id: id,
        task: task 
      });
      let output = JSON.stringify(input);
      fs.writeFile("list.json", output, (err) => {
        if (err) {
          console.log(err);
          return;
        }
      })
    });
    res.send(`You added this task: ${task}`);
  });
 
  // app.delete('/tasks/remove',(req, res) => {
  //   let removed = req.body.removed || "<unknown>";
  //   res.send(`You're done with this: ${removed}`);
  // });
  app.get('/tasks/remove',(req, res) => {
    let id = req.query.id || "<unknown>";
 
    fs.readFile('list.json',(err, content) => {
      if (err) {
          console.error(err);
          return;
      }
 
      input = JSON.parse(content);
      let findId = input.list.findIndex((task) => task.id === id);
      if(findId > -1) {
        input.list.splice(findId , 1);
      }
 
      let output = JSON.stringify(input);
      fs.writeFile("list.json", output, (err) => {
        if (err) {
          console.log(err);
          return;
        }
      })
    });
    res.send(`You removed the task with this number: ${id}`);
  });
