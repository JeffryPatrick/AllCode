const gameBoard = document.getElementById("gameboard"); //getting id of gameboard canvas
const context = gameBoard.getContext("2d"); // context of the gameboard
const width = gameBoard.width; // width of the gameboard
const height = gameBoard.height; // height of the gameboard
const foodUnit = 25; //size of the food

// score value and score text
const scoreText = document.getElementById("scoreValue"); //getting id of score
let score = 0; // initialize score value to 0

// coordinates of food
let foodX;
let foodY;

// coordinates of snake
let snake = [
  { x: foodUnit * 3, y: 0 },
  { x: foodUnit * 2, y: 0 },
  { x: foodUnit, y: 0 },
  { x: 0, y: 0 },
];

// velocity of snake
let xVel = 25;
let yVel = 0;

// game start, over variable
let active = true;
let started = false;
const spaceBar = 32;

// Event listener for keyboard
window.addEventListener("keydown", keyPress);

// function called
startGame();

/**
 * Implementation of startGame() 
 */
function startGame() {
  context.fillStyle = "#0f3704";
  // fillRect(xcoord, ycoord, width, height)
  context.fillRect(0, 0, width, height);
  createFood();
  displayFood();
  drawSnake();
}

/**
 * Implementation of keyPress()
 */
function keyPress(event) {
  if (!started && event.keyCode == spaceBar) {
    started = true;
    nextTick();
  }
  const left = 37;
  const up = 38;
  const right = 39;
  const down = 40;

  switch (true) {
    case event.keyCode == left && xVel != foodUnit:
      xVel = -foodUnit;
      yVel = 0;
      break;
    case event.keyCode == up && yVel != foodUnit:
      xVel = 0;
      yVel = -foodUnit;
      break;
    case event.keyCode == right && xVel != -foodUnit:
      xVel = foodUnit;
      yVel = 0;
      break;
    case event.keyCode == down && yVel != -foodUnit:
      xVel = 0;
      yVel = foodUnit;
      break;
  }
}

/**
 * Implementation of nextTick()
 */
function nextTick() {
  if (active) {
    setTimeout(() => {
      clearBoard();
      displayFood();
      moveSnake();
      drawSnake();
      checkGameOver();
      nextTick();
    }, 150);
  } else {
    clearBoard();
    context.font = "bold 50px serif";
    context.fillStyle = "white";
    context.textAlign = "center";
    context.fillText("Game Over!", width / 2, height / 2);
  }
}

/**
 * Implementation of clearBoard()
 */
function clearBoard() {
  context.fillStyle = "#0f3704";
  // fillRect(xcoord, ycoord, width, height)
  context.fillRect(0, 0, width, height);
}

/**
 * Implementation of createFood()
 */
function createFood() {
  foodX = Math.floor((Math.random() * width) / foodUnit) * foodUnit;
  foodY = Math.floor((Math.random() * height) / foodUnit) * foodUnit;
}

/**
 * Implementation of displayFood()
 */
function displayFood() {
  context.fillStyle = "red";
  context.fillRect(foodX, foodY, foodUnit, foodUnit);
}

/**
 * Implementation of drawSnake()
 */
function drawSnake() {
  context.fillStyle = "yellow";
  context.strokeStyle = "#212121";
  snake.forEach((snakeCoord) => {
    context.fillRect(snakeCoord.x, snakeCoord.y, foodUnit, foodUnit);
    context.strokeRect(snakeCoord.x, snakeCoord.y, foodUnit, foodUnit);
  });
}

/**
 * Implementation of moveSnake()
 */
function moveSnake() {
  const head = { x: snake[0].x + xVel, y: snake[0].y + yVel };
  snake.unshift(head);
  if (snake[0].x == foodX && snake[0].y == foodY) {
    score += 1;
    scoreText.textContent = score;
    createFood();
  } else {
    snake.pop();
  }
}

/**
 * Implementation of checkGameOver()
 */
function checkGameOver() {
  switch (true) {
    case snake[0].x < 0:
      active = false;
    case snake[0].x >= width:
      active = false;
    case snake[0].y < 0:
      active = false;
    case snake[0].y >= height:
      active = false;
  }
}
