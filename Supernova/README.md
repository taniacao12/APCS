# Tetris
Created by: Supernova (Xinyi Huang, Tania Cao, Angela Tom)

## General Description
This is a tetris game, where you try to fill as many rows as possible. Whenever as row is filled, it is cleared and everything to the top of it is brought down. In addition, points are accumulated based on the number of lines cleared and the method used to move the tetrominos. Although there's an infinite number of levels, level 29 is known to be impossible for humans to pass.

## How It Works
Our program is made up of 6 classes: TetrisV5, Tetromino, Shape, Grid, Scoreboard, and Queue. TetrisV5, a subclass of Scoreboard, serves as the main class that displays all aspects of the game itself. Queue is also a subclass of Scoreboard, and it will use merge sort for the top 5 scores to be displayed in the scoreboard. Tetromino and Grid are subclasses of TetrisV5. Tetromino has all the methods that will change the coordinates and orientation of the shapes, while Grid places the Tetrominos into a grid to make it easier to display. Last but not least, Shape is the subclass of Tetromino as it creates all the shapes.

## Instructions
If you are using a Linux product, you may follow the instructions below:
1. Download Processing using the following link: https://processing.org/download/
2. Open a terminal and direct to this repo's folder
3. Type the following into the terminal:
```
cd TetrisV5
Processing TetrisV5
```
4. Run the program
    1. Press <kbd> Crtl </kbd> + <kbd> R </kbd> on your keyboard
    2. Click on the play button on top of the "TetrisV5" tab

If you aren't using a Linux product, you may follow the instructions below:
1. Download Processing using the following link: https://processing.org/download/
2. Download this repository's files
3. Open the repo's folder
4. Open the folder named "TetrisV5"
5. Double-click on any of the files
6. Run the program
    1. Press <kbd> Crtl </kbd> + <kbd> R </kbd> on your keyboard
    2. Click on the play button on top of the "TetrisV5" tab

Once you run the game, you'll see a start screen. Whenever you are ready to play the game, click the any part of the screen and you will be directed to the game screen. Your current level and score will be displayed on right of the game grid and the next tetromino will be at the center of the screen. In the grid, the current tetromino will start moving from the top center of the grid. To control the tetromino, use the following commands:
* <kbd> → </kbd> to move the tetromino to the right
* <kbd> ← </kbd> to move the tetromino to the left
* <kbd> ↓ </kbd> for a soft drop
* <kbd> SPACE </kbd> for a hard drop

When the game is over, you will be able to replay by clicking anywhere on the screen.
