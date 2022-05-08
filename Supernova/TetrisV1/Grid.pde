class Grid {
   int grid[][] = new int[10][20];
   
   Grid() {
      for(int i = 0; i < 10; i++){
         for (int j = 0; j < 20; j++){
             grid[i][j] = 0;
         }
      }
   }
   
   boolean isOccupied(int x, int y){
      if(x < 10 && y < 20){
         return grid[x][y] == 0; 
      }
      return false;
   }
   
   
}
