/*A Matrix Created Based On 2D Array
*/

final public class Board {
    private int A; // number of rows
    private int B; // number of columns
    private double[][] Grid_Points; // An 2D Array

    public void Used(int x, int y) {
    	Grid_Points[x][y] = 1; //Points that will be used in the Boards    	
    }
    public double Shot(int x, int y) { //Do we have a hit or a miss?
    		return Grid_Points[x][y];
    	}
    public void Set_Size(int width, int height) {
    	this.A = width;
        this.B = height;
        Grid_Points = new double[A][B];
    }
    public void print() {
    	for (int i = 0; i < A; i++) {
    		for (int j = 0; j < B; j++) {
    			System.out.print(Grid_Points[i][j] + ", ");
    		}
    		System.out.println();
    	}
    }
	public int getWidth() {
		return A;
	}
	public void setWidth(int a) {
		A = a;
	}
	public int getHeight() {
		return B;
	}
	public void setHeight(int b) {
		B = b;
	}
	public void choose(int x, int y, int z) {
		Grid_Points[x][y] = z;
	}
}