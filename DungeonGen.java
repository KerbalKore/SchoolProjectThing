import java.util.*;
import java.awt.*;
public class DungeonGen {
    public static final int gridHeight = 2;
    public static final int gridWidth = 2; 
    
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500, 500);
        Graphics g = panel.getGraphics();
        Square[][] gridArr = setupSquares(180, 40);
        drawBoxes(panel, g, gridArr, 180, 40);
        pickOpenWalls(gridArr[0][0], 1);
        drawDoors(panel, g, gridArr[0][0], 180, 40);
        pickOpenWalls(gridArr[1][1], 1);
        drawDoors(panel, g, gridArr[1][1], 180, 40);
    }
    
    public static void drawDoors(DrawingPanel panel, Graphics g, Square SQ, int boxSize, int gapSize) {
        int lineMidX = 0;
        int lineMidY = 0;
        int x1 = 0; 
        int y1 = 0; 
        int x2 = 0; 
        int y2 = 0; 

        for (int i = 0; i < 4; i++) {
            boolean wall = SQ.getWallState(i);
            if (i == 1) {
                lineMidX = SQ.getX() + boxSize/2;
                lineMidY = SQ.getY();
            }
            if (i == 2) {
                lineMidX = SQ.getX() + boxSize;
                lineMidY = SQ.getY() - boxSize/2;
            }
            if (i == 3) {
                lineMidX = SQ.getX() + boxSize/2;
                lineMidY = SQ.getY() - boxSize;
            }
            if (i == 4) {
                lineMidX = SQ.getX();
                lineMidY = SQ.getY() - boxSize/2;
            }
            if (i == 1 || i == 3) {
                x1 = lineMidX; 
                y1 = lineMidY + 25; 
                x2 = lineMidX; 
                y2 = lineMidY - 25; 
            }
            if (i == 2 || i == 4) {
                x1 = lineMidX + 25; 
                y1 = lineMidY; 
                x2 = lineMidX - 25; 
                y2 = lineMidY; 
            }
            if (wall = true) {
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }
    
    public static Square[][] setupSquares(int boxSize, int gapSize) {
        Square NW = new Square(false, false, false, false, 50, 50);
        Square NE = new Square(false, false, false, false, 50 + boxSize + gapSize, 50);
        Square SW = new Square(false, false, false, false, 50, 50 + boxSize + gapSize);
        Square SE = new Square(false, false, false, false, 50 + boxSize + gapSize, 50 + boxSize + gapSize);
        Square[][] gridArr = { {NW, NE}, {SW, SE} };
        return gridArr;
        
    }
    
    public static void pickOpenWalls(Square SQ, int numWalls) {
        Random randNum = new Random();
        int wallNum = 0;
        for (int i = numWalls; i > 0; i--) {
            wallNum = randNum.nextInt(3);
            if (SQ.getWallState(wallNum) == false) {
                SQ.setWallState(wallNum, true);
            }
        }
    }
    
    public static void drawBoxes(DrawingPanel panel, Graphics g, Square[][] gridArr, int boxSize, int gapSize) {
        panel.setBackground(Color.WHITE);
        g.setColor(Color.RED);
        Square NW = gridArr[0][0];
        Square NE = gridArr[0][1];
        Square SW = gridArr[1][0];
        Square SE = gridArr[1][1];
        for (int i = 1; i <= 4; i++) {
            if (i == 1) {
                g.drawRect(NW.getX(), NW.getY(), boxSize, boxSize);
            }
            else if (i == 2) {
                g.drawRect(NE.getX(), NE.getY(), boxSize, boxSize);
                
            }
            else if (i == 3) {
                g.drawRect(SW.getX(), SW.getY(), boxSize, boxSize);
            }
            else if (i == 4) {
                g.drawRect(SE.getX(), SE.getY(), boxSize, boxSize);
            }
            else {
                System.out.println("wtf");
            }
        }
    }
}    