
public class App {

    static int[][] world = {
        {0, 7, 0, 0, 0, 2, 0, 0, 0},
        {9, 2, 0, 0, 0, 6, 0, 0, 0},
        {0, 0, 0, 4, 8, 3, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 8, 0, 3},
        {8, 0, 0, 0, 0, 0, 0, 0, 0},
        {3, 0, 0, 6, 0, 0, 0, 0, 4},
        {0, 5, 1, 0, 0, 0, 0, 9, 0},
        {0, 0, 0, 0, 4, 0, 0, 6, 0},
        {0, 0, 0, 1, 0, 0, 2, 0, 0}
    };
    
    public static void main(String[] args) throws Exception {

        if (solve())
        	draw();
        else
            System.out.println("i can't solve it !");

    }

    static boolean solve(){

        int x, y;
        int[] p;
        if ((p = nextCell())[0] == -1)
            return true;

        x = p[0];
        y = p[1];

        for (int i=1; i<=9; i++){
            if (isValid( x, y ,i)) {
                world[x][y] = i;
                
                if (solve())
                    return true;
                    
                world[x][y] = 0;
            }
        }
            
        return false;

    }

    static void draw(){

    	System.out.print(" ----------------------- \n");


        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                if (j%3==0)
                    System.out.print("| ");
                
                System.out.print(world[i][j] + " ");
            }

            if ((i+1) % 3 == 0)
                System.out.print("| \n ----------------------- \n");
		    else
                System.out.print("| \n");
        }


    }

    static boolean isValid(int x , int y , int n ){

        for (int i = 0; i < 9; i++) {
            if ( world[i][y] == n || world[x][i] == n) {
                return false;
            }
        }

        x = (x/3) * 3;
        y = (y/3) * 3;

        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                if ( world[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }

    static int[] nextCell(){

        int[] point = new int[2];

        point[0] = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (world[i][j] == 0) {
                    
                    point[0] = i;
                    point[1] = j;

                    break;
                }
            }
        }

        return point;
    }
}
