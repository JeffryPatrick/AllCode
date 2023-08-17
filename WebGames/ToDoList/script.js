let button = document.getElementById("add");
let todoList = document.getElementById("toDoList");
let input = document.getElementById("input");

let todos = [];

button.addEventListener("click", () => {
  todos.push(input.value);
  addToDo(input.value);
});

function addToDo(todo) {
    let para = document.createElement('p');
    para.innerText = todo;
    todoList.appendChild(para);
}