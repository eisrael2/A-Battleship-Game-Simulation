import java.io.FileOutputStream;
import java.io.PrintWriter;

public class BattleshipSearch {
	
	Search_Strategy strategy;
	Results results;
	
	PrintWriter out = null;
	public BattleshipSearch(Search_Strategy input_strat, PrintWriter FOS) {
		strategy = input_strat;
		out = FOS;
	}
	
	public void play(Board board) {
		results = strategy.Search(board);
	}
	public void print() {
		
		out.println("Strategy: " + strategy.toString());
		out.println("Number of cells searched: " + results.searched);
		out.println("Carrier found: (" + results.array[0] + ", " + results.array[1] + ") to (" + results.array[2] +
				            ", " + results.array[3]+ ") Submarine found: (" + results.array[4] + ", " + results.array[5] + ") to (" + results.array[6] + ", " + results.array[7] + ")");
	}
}