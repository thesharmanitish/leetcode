enum Direction{
    NORTH,EAST,WEST,SOUTH; 

    
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public boolean isRobotBounded(String instructions) {
        Direction dir = Direction.NORTH;
        Pair p = new Pair(0,0);
        for(int i=0;i<4;i++){
            for(char c:instructions.toCharArray()){
                switch(c){
                    case 'G': {
                                move(dir, p);
                                break;
                              }
                    case 'L': {
                                dir = rotateRight(dir, -1);
                                break;
                              }
                    case 'R': {
                                dir = rotateRight(dir, 1);
                                break;    
                              }
                }
            }
            if(p.x ==0 && p.y ==0)
                return true;            
            else if(dir == Direction.NORTH)
                return false;

        }
        return false;
    }
        public void move(Direction direction, Pair p) {
            switch(direction){
                case NORTH :{
                                      p.x +=1;
                                      break;
                                     }
                case EAST : {
                                      p.y -=1;
                                      break;
                                     }
                case WEST : {
                                      p.y +=1;
                                      break;
                                    }
                case SOUTH : {
                                      p.x -=1;
                                      break;
                                      }
            }
            
        }
    Direction rotateRight(Direction d, int rotate){
        switch(d){
                case NORTH :{
                                      if(rotate ==-1)
                                        return Direction.WEST;
                                      else   
                                          return Direction.EAST;
                                     }
                case EAST : {
                                     if(rotate ==-1)
                                        return Direction.NORTH;
                                      else   
                                          return Direction.SOUTH;
                                     }
                case WEST : {
                                      if(rotate ==-1)
                                        return Direction.SOUTH;
                                      else   
                                          return Direction.NORTH;
                                     }
                case SOUTH : {
                                       if(rotate ==-1)
                                        return Direction.EAST;
                                       else   
                                          return Direction.WEST;
                                      }
        }
        return Direction.NORTH;
    }            
}