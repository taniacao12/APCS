ArrayList<Shape> pieces = new ArrayList();
Shape currPiece; 
PImage img;
boolean gameStart = false;
int xpos;
int ypos;
int score = 0;
int  unit = 30;
int time;
Grid g = new Grid();
Scoreboard scores;
boolean gameOver;

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

  newPiece();
}

void draw() {
  if (gameOver) {
    endGame();
  }
  if (gameStart == false) {
    image(img, 0, 0, 1024, 768);
    textSize(50);
    text("START", 430, 450);
  } else {
    try {
      background(0);
      g.display();
      currPiece.display(); 

      //println(currPiece.getX(), currPiece.getY());
      if (ypos == 19 || g.isOccupied(xpos, ypos + 1)) {
        //g.printGrid();
        currPiece.stop();

        g.setOccupied();

        currPiece.stop(); 
        newPiece();
        //g.printGrid();
      } else {
        currPiece.fall();
      }
      g.removeRow();
    } 
    catch(Exception e) {
      gameOver = true;
      endGame();
    }
  }
}

void newPiece() {
  currPiece = pieces.get(int(random(pieces.size())));
  xpos = 2;
  ypos = 0;
}

void mouseClicked() {
  if (gameStart == false && (mouseX < 600 && mouseX > 425) && ((mouseY < 460) && (mouseY > 400))) {
    gameStart = true;
  }
}
void keyPressed() {
  if (key == CODED) {
    if (keyCode == LEFT && currPiece.getX() > 1 && !g.isOccupied(xpos - 1, ypos)) {
      try {
        xpos--;
      }
      catch (Exception e) {
        println("Game Over");
        gameOver = true;
        endGame();
      }
    }

    if (keyCode == RIGHT && currPiece.getX() < 9 && !g.isOccupied(xpos + 1, ypos)) {
      try {
        xpos++;
      } 
      catch (Exception e) {
        println("Game Over");
        gameOver = true;
        endGame();
      }
    }


    if (keyCode == DOWN) {
      try {
        drop();
      } 
      catch (Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
    }
  }
}

void drop() {
  for (int i = 19; i >= 0; i--) {
    if (!g.isOccupied(xpos, i)) {
      if (!g.isOccupied(xpos, i -= 1)) {
        if (!g.isOccupied(xpos, i -= 2)) {
          if (!g.isOccupied(xpos, i -= 3)) {
            ypos = i + 6;
            try {
              g.setOccupied();
            } 
            catch(Exception e) {
              endGame();
              println("Game Over");
              gameOver = true;
            }
            ypos +=0;
            newPiece();
            return;
          }
        }
      }
    }
  }
}

void endGame() {
  background(#FFFF9D);
  scores.add(score);
  textSize(50);
  fill(255);
  text("Score: " + score, 430, 450);
  text("Top Scores: " + scores.getTopScores(), 430, 500);
}
