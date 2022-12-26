const express = require('express');
const fs = require('fs');

let app = express();

//1. Viewing the to-do list 
app.get('/tasks', (req, res) => {
    fs.readFile('task_list.json', (error, content) => {
        if (error) {
            console.error(error);
            return;
        }

        res.send(`Hey there! Here are your tasks: ${content}`);
    });

   });

// 2. Adding a task to To Do List 
   app.get('/tasks/new',(req, res) => {
       let newId = req.query.id || "<unknown>";
       let newTask = req.query.task || "<unknown>";

        fs.readFile('task_list.json', (error, content) => {
            if (error) {
                console.error(error);
                 return;
            }
            
            input = JSON.parse(content);
           
            input.list.push({
                id: newId, 
                task: newTask
            });

            let output = JSON.stringify(input);

            fs.writeFile('task_list.json', output, (error) => {
                res.send(`You just added the following task to your To-Do List: ${newTask}`);
            } );

        });

   });

   //3. Removing an item from the To-Do List
   app.get('/tasks/remove',(req, res) => {
    let id = req.query.id || "<unknown>";
 
    fs.readFile('task_list.json',(error, content) => {
      if (error) {
          console.error(error);
          return;
      }
 
      input = JSON.parse(content);

      //finding the ID of the task we want to remove
      let findId = input.list.findIndex((task) => task.id === id);

      if(findId > -1) {
        input.list.splice(findId , 1); //extract the task from the to-do lsit
      }
 
      let output = JSON.stringify(input);

      fs.writeFile("task_list.json", output, (error) => {
       
        if (error) {
          console.log(error);
          return;
        }

      })

    });

    res.send(` Task with the ID: ${id} was removed from the To-Do List!`);

  });

app.listen(3000, () => {
 console.log('listening on port 3000 woohoo!');
});