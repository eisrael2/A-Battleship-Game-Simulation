import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Games {
	
	final int dimension = 25;
	Board[] games = new Board[3];
	
	public Games() {
		games[0] = new Board();
		games[0].Set_Size(25,25);
		games[1] = new Board();
		games[1].Set_Size(25,25);
		games[2] = new Board();
		games[2].Set_Size(25,25);
	}
	public void read_File(){
		read_File("C:\\Users\\eisrael2\\Desktop\\input.txt");
	}

	public void read_File(String fileName){
		   int counter = 0;
		   try {
			  FileReader inputFile = new FileReader(fileName);
			  BufferedReader reader = new BufferedReader(inputFile);
	          StringTokenizer tokenizer;
			  String line;
			  while((line = reader.readLine()) != null) { // read each line
				  tokenizer = new StringTokenizer(line, "(,)");
				  int countThis = 0;
				  while(tokenizer.hasMoreTokens()) {
					  int x = Integer.parseInt(tokenizer.nextToken());
					  int y = Integer.parseInt(tokenizer.nextToken());
					  games[counter].Used(x, y);
					  if (countThis < 5) {
						  games[counter].choose(x, y, 1);
					  }
					  if (countThis < 8 && countThis >= 5) {
						  games[counter].choose(x, y, 2);
					  }
					  countThis++;
				  }
				  counter++;
			  }
			  reader.close();
		    } catch (Exception e) {
			  e.printStackTrace();   
			}   
		}
		
		public static void main(String[] args) {
			Games game = new Games();
			game.read_File();

			
			FileWriter out;
			try {
				out = new FileWriter("output.txt");

				PrintWriter print_line = new PrintWriter(out);
				for(int i = 0; i < 2; i++) {
					BattleshipSearch b = new BattleshipSearch(new Horizontal_Sweep_Strategy(), print_line);
					b.play(game.games[i]);
					b.print();
					
					b = new BattleshipSearch(new Diagonally_Search_Stratergy(), print_line);
					b.play(game.games[i]);
					b.print();
					
				    b = new BattleshipSearch(new Random_Search_Strategy(), print_line);
					b.play(game.games[i]);
					b.print();
				}
				print_line.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}




