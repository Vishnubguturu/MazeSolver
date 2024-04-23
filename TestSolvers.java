import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Compare two mazes to help with testing*/
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Method to format String[] output as String to help with testing*/
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}
	
	@Test
	public void testMazeStack() {
		Maze m = new Maze(new String[] {
				"_#__",
				"___F",
				"S##_",
				"____"
		});
		
		String[] s = {
				"_#__",
				"___F",
				"S##*",
				"****",
		};
		
		SearchWorklist sl = new StackWorklist();
		checkMaze(sl, m, s);
	}
	
	@Test
	public void testMazeQueue() {
		Maze m = new Maze(new String[] {
				"_#__",
				"___F",
				"S##_",
				"____"
		});
		
		String[] q = {
				"_#__",
				"***F",
				"S##_",
				"____"
		};
		
		SearchWorklist ql = new QueueWorklist();
		checkMaze(ql, m, q);
	}
	
	@Test
	public void testcorners() {
		Maze m = new Maze(new String[] {
				"S###",
				"_##_",
				"_###",
				"___F"
		});
		
		String[] n = {
				"S###",
				"*##_",
				"*###",
				"***F"
		};
		
		SearchWorklist wl = new StackWorklist();
		checkMaze(wl, m, n);
	}
	
	@Test
	public void testnowalls() {
		Maze m = new Maze(new String[] {
				"S___",
				"____",
				"____",
				"___F"
		});
		
		String[] n = {
				"S___",
				"*___",
				"*___",
				"***F"
		};
		
		SearchWorklist wl = new QueueWorklist();
		checkMaze(wl, m, n);
	}
	
	@Test
	public void testSF() {
		Maze m = new Maze(new String[] {
				"__#_",
				"__##",
				"#FS_",
				"___#"
		});
		
		String[] n = {
				"__#_",
				"__##",
				"#FS_",
				"___#"
		};
		
		SearchWorklist wl = new StackWorklist();
		checkMaze(wl, m, n);
	}
}
