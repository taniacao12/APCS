PImage img;
Grid gameBoard, nextBoard, holdBoard;
Tetromino current;
Shape next;
Shape hold;
Shape[] shapes = new Shape[7];
Scoreboard scoreboard;
int timer = 20;
int currentTime = 0;
int score = 0;
int lines = 0;
int level = 1;
final int SPEED_DECREASE = 2;
boolean gameStart = false;
boolean gameOver = false;

void setup() {
  size(1024, 768, P2D); // set the dimensions of the screen
  textSize(25); // set the size of any text on the screen
  img = loadImage("startPage.jpg"); // load the image of the start page
  // create all shapes
  shapes[0] = new Shape(4, new int[] {8, 9, 10, 11}, #D4A3DE);  // I
  shapes[1] = new Shape(3, new int[] {0, 3, 4, 5}, #9CFAC2);  // J
  shapes[2] = new Shape(3, new int[] {2, 3, 4, 5}, #ADB2E8);  // L
  shapes[3] = new Shape(2, new int[] {0, 1, 2, 3}, #FFFF9D);  // O
  shapes[4] = new Shape(4, new int[] {5, 6, 8, 9}, #F5B2F2);  // S
  shapes[5] = new Shape(3, new int[] {1, 3, 4, 5, }, #FF9D9D);  // T
  shapes[6] = new Shape(4, new int[] {4, 5, 9, 10}, #B2F5F4);  // Z
  scoreboard = new Scoreboard();
  // initiate all grids
  gameBoard = new Grid(20, 20, 321, 642, 20, 10);
  nextBoard = new Grid(355, 20, 116, 58, 2, 4);
  holdBoard = new Grid(355, 60, 116, 58, 2, 5);
  next = shapes[(int)random(7)]; // set the next shape as a random one from the list of shapes
  loadNext();
}

void draw() {
  if (gameStart == false) {
    image(img, 0, 0, 1024, 768);
    textSize(50);
    text("CLICK ANYWHERE TO START", 175, 50);
  } else {
    background(0); // set the background color as black
    textSize(25);
    if (gameOver) { // if the game is over, print out the results of the game (score)
      scoreboard.add(score);
      text("GAME OVER\nYOUR SCORE: " + score, width/2 - 70, height/2 - 50);
      //text("GAME OVER\nSCOREBOARD: " + scoreboard.getTopScores(), width/2, height/2);
      text("CLICK ANYWHERE TO RESTART", width/2 - 175, height/2 + 30);
      return;
    }
    currentTime++;
    if (currentTime >= timer && gameBoard.animateCount == -1)
      current.stepDown();
    nextBoard.draw();
    gameBoard.draw();
    if (current != null)
      current.draw();
    next.nextBoard();
    fill(255); // set the color of the text white
    text("LEVEL\n" + level, width - 150, 120);
    text("LINES\n" + lines, width - 150, 200);
    text("SCORE\n" + score, width - 150, 280);
    text("CLICK ESC KEY TO CLOSE THE GAME", 300, height - 50);
  }
}

// update tetrominos --> set current as the tetromino using the next shape and update next with a new random shape
void loadNext() {
  current = new Tetromino(next);
  next = shapes[(int)random(7)];
  currentTime = 0;
}

// starts the game when the start button is clicked
void mouseClicked() {
  if (gameStart == false && gameOver == false && (mouseX < 1024 && mouseX > 0) && ((mouseY < 768) && (mouseY > 0)))
    gameStart = true;
  else if (gameStart == true && gameOver == true && (mouseX < 1024 && mouseX > 0) && ((mouseY < 768) && (mouseY > 0))) {
    gameStart = false;
    play();
  }
}

// precondition: lines are not being cleared and the game is not over
// actions to be completed when certain keys on the keyboard are pressed
void keyPressed() {
  if (current == null || gameOver || !gameStart)
    return;
  switch(keyCode) {
  case LEFT : 
    current.left(); 
    break;
  case RIGHT : 
    current.right(); 
    break;
  case UP : 
    current.rotate(); 
    break;
  case DOWN : 
    current.down(); 
    break;
  case ' ' :
    current.hardDown(); 
    break;
  }
}

// restart the game --> clear the boards and replay
void play () {
  textSize(25); // set the size of any text on the screen
  img = loadImage("startPage.jpg"); // load the image of the start page
  // initiate all grids
  gameBoard = new Grid(20, 20, 321, 642, 20, 10);
  nextBoard = new Grid(355, 20, 116, 58, 2, 4);
  next = shapes[(int)random(7)]; // set the next shape as a random one from the list of shapes
  loadNext();
}
