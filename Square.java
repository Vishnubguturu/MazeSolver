/*Class that implements a single unit in a Maze*/

class Square {

	@Override
	public String toString() {
		return "Square [row=" + row + ", col=" + col + ", isWall=" + isWall + ", visited=" + visited + "]";
	}

	private final int row, col;			//the x,y position of a square
	private final boolean isWall;		//if the square is a wall
	private Square previous = null;		//the previously visited square
	private boolean visited = false;	//if the square has been visited

	public Square(int x, int y, boolean isWall) {
		this.row = x;
		this.col = y;
		this.isWall = isWall;
	}
	
	public int getRow() { return this.row; }
	public int getCol() { return this.col; }
	public boolean getIsWall() { return this.isWall; }
	public boolean isVisited() { return this.visited; }
	public Square getPrevious() { return this.previous;	}
	
	public void visit() {
		this.visited = true;
	}
	public void setPrevious(Square previous) {
		this.previous = previous;
	}
}
