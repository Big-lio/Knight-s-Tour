import java.util.*;
import java.io.*;
public class KnightsTour {
    static int initialX;
    static int initialY;
    static int N; // Length of the board
    static int NN; // Number of squares
    static int[][] BOARD; // visit order
    static int[] CX = new int[]{2, 1, -1, -2, -2, -1,  1,   2}; // legal horizontal moves
    static int[] CY = new int[]{1, 2,  2,  1, -1, -2, -2, -1}; // legal vertical moves
    static boolean YES; 
    static int i=0;
    static StringBuffer part2 = new StringBuffer();
    static boolean backtrack=false;

    static void INITIALIZE() {
        BOARD = new int[N][N];
        NN = N * N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = 0;
            }
        }
    }


    static boolean isValidMove(int line, int column ) {
        return ((line >= 1 && line <= N) && (column >= 1 && column <= N) && BOARD[line - 1][column - 1] == 0); 
        
    }

    static boolean isOutOfBounds(int line, int column ) {
        return (line < 1 || line > N || column < 1 || column > N); 
        
    }

    static boolean isOccupied(int line, int column ) {
        return (BOARD[line - 1][column - 1] != 0); 
        
    }


    static void TRY(int visitingOrder, int X, int Y) {
        
        for (int K = 0; K < 8; K++) {
            int line = X + CX[K];
            int column = Y + CY[K];

            if (isValidMove(line, column)) {
                backtrack=false;
                i+=1;
                part2.append(String.format("%08d", i) + ")");
                part2.append(" " + repeat("-", K,backtrack) + "R" + (K + 1) + ".");
                part2.append(" Line = " + line + ", Column = " + column + ". Visiting order = " + visitingOrder + "." + " Free. BOARD[" + line + "," + column + "]:=" + visitingOrder + ".");
                part2.append("\n");
                BOARD[line-1][column-1] = visitingOrder;
                
                if (visitingOrder==N*N) {
                    YES=true;
                    return;
                }
                else {
                    TRY(visitingOrder+1, line, column);
                    if (!YES) {
                        backtrack=true;
                        BOARD[line-1][column-1] = 0;
                        part2.append(String.format("%08d", i) + ")");
                        part2.append(" " + repeat("-", K,backtrack) + "R" + (K + 1) + ".");
                        part2.append(" Line = " + line + ", Column = " + column + ". Visiting order = " + visitingOrder + "." + " Backtrack.");
                        part2.append("\n");
                        
                        
                    }
                    else{
                        
                        return;
                    }
                }
            }
            else{
                i+=1;
                backtrack=false;
                if(isOutOfBounds(line,column)){
                    part2.append(String.format("%08d", i) + ")");
                    part2.append(" " + repeat("-", K, backtrack) + "R" + (K + 1) + ".");
                    part2.append(" Line = " + line + ", Column = " + column + ". Visiting order = " + visitingOrder + "." + " Out .");
                    part2.append("\n");
                }
                else if (isOccupied(line,column)){
                    part2.append(String.format("%08d", i) + ")");
                    part2.append(" " + repeat("-", K, backtrack) + "R" + (K + 1) + ".");
                    part2.append(" Line = " + line + ", Column = " + column + ". Visiting order = " + visitingOrder + "." + " Thread.");
                    part2.append("\n");
                }
                
            }    
        }
          
        
        
    }



    static int pavles=-1;
    static String repeat(String str, int K, boolean backtrack) {

        StringBuilder sb = new StringBuilder();

        if (K+1==1 && !backtrack){
            pavles++;
            for (int i = 0; i < pavles; i++) {
                sb.append(str);
            }
        }

        if (backtrack) {
            pavles--;
            for (int i = 0; i < pavles; i++) {
                sb.append(str);
            }
        }

        if (K>0 && !backtrack){
            for (int i = 0; i < pavles; i++) {
                sb.append(str);
            }
        }
        return sb.toString();
    }





    static void printBoard() {
        System.out.println();
        System.out.println("  Y");
        System.out.println("  ^");
        System.out.println("  |");
        for (int i = N - 1; i >= 0; i--) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < N; j++) {
                System.out.printf(" %02d", BOARD[j][i], " ");

                System.out.print(" |");
            }
            
            System.out.println();
        }
        System.out.println("   --------------------------> X");
        System.out.print(" ");
        for (int i = 1; i <= N; i++) {
            System.out.print("  " + i + "   ");
        }
        
    }


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the length of the board (N): ");
            N = scanner.nextInt();
            
            System.out.print("Enter the initial position X: ");
            initialX = scanner.nextInt();
            
            System.out.print("Enter the initial position Y: ");
            initialY = scanner.nextInt();
            // Create file writers
            PrintWriter outShort = new PrintWriter(new FileWriter("out-short.txt"));
            PrintWriter outLong = new PrintWriter(new FileWriter("out-long.txt"));

            // PART 1. Data
            String part1 = "PART 1. Data\n" +
                    " 1) Board: " + N + "x" + N + ".\n" +
                    " 2) Initial position: X=" + initialX + ", Y=" + initialY + ". L=1.\n";
            
            System.out.println(part1);
            outShort.println(part1);
            outLong.println(part1);

            INITIALIZE();

            YES = false;
            BOARD[initialX - 1][initialY - 1] = 1;

            // PART 2. Trace
            String part2_ = "PART 2. Trace\n";
            outLong.println(part2_);

            TRY(2, initialX, initialY);

            if (YES) {
                outLong.println(part2);
            }
            else {
                System.out.println(" Path does not exist.");
                outLong.println(" Path does not exist.");
                outLong.println(part2);
            }

            // PART 3. Results
            String part3 = "PART 3. Results\n";
            System.out.println(part3);
            outShort.println(part3);
            outLong.println(part3);

            if (YES) {
                String result1 = " 1) Path is found. Trials=" + i + ".\n";
                String result2 = " 2) Path graphically:\n";
                System.out.println(result1);
                System.out.println(result2);
                outShort.println(result1);
                outShort.println(result2);
                outLong.println(result1);
                outLong.println(result2);
                printBoard();
                printBoardToFile(outLong);
                printBoardToFile(outShort);
            } else {
                String result = " 1) Path does not exist. Trials=" + i + ".\n";
                System.out.println(result);
                outShort.println(result);
                outLong.println(result);
            }

            // Close file writers
            outShort.close();
            outLong.close();
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    static void printBoardToFile(PrintWriter out) {
        out.println();
        out.println("  Y");
        out.println("  ^");
        out.println("  |");
        for (int i = N - 1; i >= 0; i--) {
            out.print((i + 1) + " |");
            for (int j = 0; j < N; j++) {
                out.printf(" %02d", BOARD[j][i], " ");
                out.print(" |");
            }
            out.println();
        }
        out.println("   --------------------------> X");
        out.print(" ");
        for (int i = 1; i <= N; i++) {
            out.print("  " + i + "   ");
        }
        out.println();
    }
}
