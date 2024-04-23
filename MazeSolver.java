/* Class that implements a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		
		Square front = maze.start;
		wl.add(front);
		front.visit();
		while(!wl.isEmpty()) {
			Square current = wl.remove();
			if(current.equals(maze.finish)) {
				return current;
			}
			else {
				//Check North
				if(availableNeighbour(maze.contents, current, -1, 0)) {
					Square North = maze.contents[current.getRow()-1][current.getCol()];
					North.visit();
					North.setPrevious(current);
					wl.add(North);
				}
				
				//Check South
				if(availableNeighbour(maze.contents, current, 1, 0)) {
					Square South = maze.contents[current.getRow()+1][current.getCol()];
					South.visit();
					South.setPrevious(current);
					wl.add(South);
				}
				
				//Check East
				if(availableNeighbour(maze.contents, current, 0, 1)) {
					Square East = maze.contents[current.getRow()][current.getCol()+1];
					East.visit();
					East.setPrevious(current);
					wl.add(East);
				}
				
				//Check West
				if(availableNeighbour(maze.contents, current, 0, -1)) {
					Square West = maze.contents[current.getRow()][current.getCol()-1];
					West.visit();
					West.setPrevious(current);
					wl.add(West);
				}
			}
		}
		return null;
	}

	//Returns true if Squares are available in the North, South, East and West directions, respectively.
	public static boolean availableNeighbour(Square[][] contents, Square s, int rowOffset, int colOffset) {
		int row = s.getRow() + rowOffset;
		int col = s.getCol() + colOffset;
		if(!(row >= 0 && col >= 0 && row < contents.length && col < contents[0].length)) {
			return false;
		}
		Square neighbour = contents[row][col];
		if(neighbour.getIsWall() || neighbour.isVisited()) {
			return false;
		}
		return true;
	}
}
