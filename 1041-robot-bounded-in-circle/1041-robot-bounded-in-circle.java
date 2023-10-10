class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0;
        int y=0;
        String direction = "NORTH";
        
        for(int i=0; i<instructions.length(); i++) {
            char currCh = instructions.charAt(i);
            if(currCh == 'G') {
                if(direction.equals("NORTH")) {
                    y+=1;
                } else if(direction.equals("SOUTH")) {
                    y-=1;
                } else if(direction.equals("EAST")) {
                    x+=1;
                } else if(direction.equals("WEST")) {
                    x-=1;
                }
            } else if(currCh == 'L') {
                if(direction.equals("NORTH")) {
                    direction = "WEST";
                } else if(direction.equals("SOUTH")) {
                    direction = "EAST";                
                } else if(direction.equals("EAST")) {
                    direction = "NORTH";                
                } else if(direction.equals("WEST")) {
                    direction = "SOUTH";                
                }
            } else if(currCh == 'R') {
                if(direction.equals("NORTH")) {
                    direction = "EAST";
                } else if(direction.equals("SOUTH")) {
                    direction = "WEST";                
                } else if(direction.equals("EAST")) {
                    direction = "SOUTH";                
                } else if(direction.equals("WEST")) {
                    direction = "NORTH";                
                }
            }
        }
        
        if(x==0 && y==0) {
            return true;
        }
        
        if(direction.equals("NORTH")) {
            return false;
        }
        
        return true;
    }
}