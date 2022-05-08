PImage img, o;
PShape j;
boolean gameStart = false;
Shape currentT = new Shape();
int score = 0;
int level = 1;
int linesCleared = 0;
Grid g = new Grid();
Shape x = new Shape();
void setup() {
  size(1024, 768);
  img = loadImage("startPage.jpg");
  background(5000000);
  o = loadImage("O.png");
}

void draw() {
  if (gameStart == false) {
    image(img, 0, 0, 1024, 768);
    //  fill(#d3d3d3);
    //  rect(425, 400, 175, 60);
    textSize(50);
    text("START", 430, 450);
  } else {
    createScreen();
    updateScore();
    updateLevel();
    drawCurrentT();
  }
}

void mouseClicked() {
  if ((mouseX < 600 && mouseX > 425) && ((mouseY < 460) && (mouseY > 400))) {
    gameStart = true;
  }
}

// set up of the game

void createScreen() {
  background(5000000);

  //rect(150, 100, 300, 600); // Location of matrix
  g.createMatrix();
  createNext();
  createHold();
}

void drawCurrentT() {

  g.drawGrid(o, currentT.xpos, currentT.ypos);
  currentT.dropDown();
}


void nextShape() {
}

void updateMatrix() {
}

void updateScore() {
  textSize(24);
  text("Score: " + score, 25, 25);
}

void updateLevel() {
  textSize(24);
  text("Level: " + level, 25, 50);
  text("Lines Cleared: " + linesCleared, 25, 75);
}

void createNext() {
  textSize(30);
  text("Next", 550, 115);
  for (int x = 510; x < 660; x += 30) {
    for (int y = 130; y < 640; y+= 30) {
      fill(#d3d3d3);
      rect(x, y, 30, 30);
    }
  }
}

void createHold() {
  textSize(30);
  text("Hold", 760, 115);
  for (int x = 720; x < 870; x += 30) {
    for (int y = 130; y < 640; y+= 30) {
      fill(#d3d3d3);
      rect(x, y, 30, 30);
    }
  }
}
