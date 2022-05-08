int xpos; 
int ypos;
int time;

int unit = 30;
boolean[] occupied = new boolean[200];
PImage img;
boolean gameStart = false;
Shape currPiece; 
int score = 0;
int level = 1;
int linesCleared = 0;
ArrayList<Shape> pieces = new ArrayList();

void setup() {
  size(1024, 768);
  img = loadImage("startPage.jpg");
  background(5000000);

  currPiece = new O();
  pieces.add(currPiece);
  currPiece = new T();
  pieces.add(currPiece);
  currPiece = new I();
  pieces.add(currPiece);
  currPiece = new J();
  pieces.add(currPiece);
  currPiece = new L();
  pieces.add(currPiece);
  currPiece = new S();
  pieces.add(currPiece);
  currPiece = new Z();
  pieces.add(currPiece);
}

void draw() {
  if (gameStart == false) {
    image(img, 0, 0, 1024, 768);
    textSize(50);
    text("START", 430, 450);
  } else {
    background(0);
    createScreen();
    updateScore();
    updateLevel();
    displayOccupied();
    if (ypos == 19 || occupied[xpos*ypos]) {
      stop();
    }
    fall();
    // display();
    currPiece.display();
    displayOccupied();
   
  }
}

// set up of the game

void createScreen() {
  background(5000000);
  //rect(150, 100, 300, 600); // Location of matrix
  createMatrix();
  createNext();
  createHold();
}

void createMatrix() {
  for (int x = 30; x < 330; x += 30) {
    for (int y = 30; y < 660; y+= 30) {
      fill(#d3d3d3);
      rect(x, y, 30, 30);
    }
  }
}

void updateScore() {
  textSize(24);
  text("Score: " + score, 400, 25);
}

void updateLevel() {
  textSize(24);
  text("Level: " + level, 400, 50);
  text("Lines Cleared: " + linesCleared, 400, 75);
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


void newPiece () {
  println ("new");
  currPiece = pieces.get(int(random(pieces.size())));
  ypos=0;
  xpos = 0;
}


void mouseClicked() {
  if (gameStart == false && (mouseX < 600 && mouseX > 425) && ((mouseY < 460) && (mouseY > 400))) {
    gameStart = true;
  }
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == LEFT && xpos > 0 && !occupied[(xpos-1)+ypos*10]) {
      xpos--;
    }
    if (keyCode == RIGHT && xpos < 9 && !occupied[(xpos+1)+ypos*10]) {
      xpos++;
    }
    if (keyCode == DOWN) {
      drop();
    }
  } else {
    if (key == 'm') {
      spin(key);
    }
    if (key == 'n') {
      newPiece ();
    }
  }
}
void fall() {

  if (millis() > time + 1000) {
    time = millis();
    ypos++;
  }
}

void stop() {
  ypos += 0;
  occupied[xpos+ypos] = true;
  newPiece();
}

void displayOccupied() {
  for (int i = 0; i < 200; i++) {
    int x = i%10;
    int y = i/10;
    if (occupied[i]) 
      fill(225);
  }
}
/*
  void display() {

    for (int i = 0; i < 200; i++) {
      int x = i%10;
      int y = i/10;
      if (occupied[i]) 
        fill(225);
      else
        fill(255);
      rect(x * unit, y * unit, unit, 3 * unit);
    }
    color c = currPiece.getColor();
    fill(c);
    rect(xpos * unit, ypos * unit, unit, unit);
  }
*/

  void drop() {
    for (int i = 19; i >= 0; i--) {
      int index = xpos+i*10;
      if (!occupied[index]) {
        occupied[index] = true;
        ypos +=0;
        newPiece();
        return;
      }
    }
  }
  void spin(char qa) {
    if (qa == 'm') {
      currPiece.rotate();
    }
  }
