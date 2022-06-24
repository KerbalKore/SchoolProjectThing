public class Square {
    private boolean WallN;
    private boolean WallE;
    private boolean WallS;
    private boolean WallW;
    private int xOrigin;
    private int yOrigin;
    public Square(boolean N, boolean E, boolean S, boolean W, int X, int Y) {
       this.xOrigin = X;
       this.yOrigin = Y;
       this.WallN = N;
       this.WallE = E;
       this.WallS = S;
       this.WallW = W;
    }
    
    public int getX() {
        return this.xOrigin;
    }
    
    public int getY() {
        return this.yOrigin;
    }
    
    // for this, Wall is from 1 to 4, 1 being north, 2 east, 3 south, 4 west, defaults to north otherwise
    public boolean getWallState(int WallName) {
        if (WallName == 1) {
            return this.WallN;
        }
        if (WallName == 2) {
            return this.WallE;
        }
        if (WallName == 3) {
            return this.WallS;
        }
        if (WallName == 4) {
            return this.WallW;
        }
        else {
            return this.WallN;
        }
    }
    
     // for this, WallName is from 1 to 4, 1 being north, 2 east, 3 south, 4 west, defaults to north otherwise
    public boolean setWallState(int WallName, boolean NewState) {
        if (WallName == 1) {
            this.WallN = NewState;
            return this.WallN;
        }
        else if (WallName == 2) {
            this.WallE = NewState;
            return this.WallE;
        }
        else if (WallName == 3) {
            this.WallS = NewState;
            return this.WallS;
        }
        else if (WallName == 4) {
            this.WallW = NewState;
            return this.WallW;
        }
        else {
            this.WallN = NewState;
            return this.WallN;
        }
    }
}