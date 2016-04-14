import java.util.ArrayList;

public class Diagonally_Search_Stratergy implements Search_Strategy {
	
	@Override
	public String toString() {
		return "Diagonally_Search_Stratergy";
	}
	
	public Results Search(Board board) {
		Results finals = new Results();
		ArrayList<Integer> carrierList = new ArrayList<>();
		ArrayList<Integer> subList = new ArrayList<>();
		int counter = 0;
		int counter2 = 0;
		for (int j = 0; j < board.getHeight(); j++) {
			for (int i = 0; i < board.getWidth(); i++) {
				if (i+j < 25) {
					if (board.Shot(i, i+j) == 1) {
						carrierList.add(i);
						carrierList.add(j);
						counter++;
					}
					if (board.Shot(i,i+j) == 2) {
						subList.add(i);
						subList.add(j);
						counter++;
					}
					if (counter == 8) {
						break;
					}
					counter2++;
				}
			}
		}
		for (int j = 0; j < board.getHeight(); j++) {
			for (int i = 0; i < board.getWidth(); i++) {
				if (i-j > 0) {
					if (board.Shot(i, i-j) == 1) {
						carrierList.add(i);
						carrierList.add(j);
						counter++;
					}
					if (board.Shot(i,i-j) == 2) {
						subList.add(i);
						subList.add(j);
						counter++;
					}
					if (counter == 8) {
						break;
					}
					counter2++;
				}
			}
		}
		carrierList = Sort_Method(carrierList);
		subList = Sort_Method(subList);
		finals.array[0] = carrierList.get(0);
		finals.array[1] = carrierList.get(1);
		finals.array[2] = carrierList.get(carrierList.size()-2);
		finals.array[3] = carrierList.get(carrierList.size()-1);
		finals.array[4] = subList.get(0);
		finals.array[5] = subList.get(1);
		finals.array[6] = subList.get(subList.size()-2);
		finals.array[7] = subList.get(subList.size()-1);
		finals.searched = counter2;
		return finals;
	}
	public ArrayList<Integer> Sort_Method (ArrayList<Integer> m) {
		int x1, y1, x2, y2;
		for(int i = 0; i < m.size()-2; i+=2) {
			for(int j = 2; j < m.size()-i; j+=2) {
				x1 = m.get(j-2);
				y1 = m.get(j-1);
				x2 = m.get(j);
				y2 = m.get(j+1);
				if(x2 < x1) {
					m.set(j-2, x2);
					m.set(j-1, y2);
					m.set(j, x1);
					m.set(j+1, y1);
				}
				else if(x2 == x1) {
					
					if(y2 < y1) {
						m.set(j-2, x2);
						m.set(j-1, y2);
						m.set(j, x1);
						m.set(j+1, y1);
					}
				}
			}
		}
		return m;
	}
}
//	}
//	public boolean Diagonal(int[][] array) {
//	    int Total = 0;
//	    for(int row = 0; row < array.length; row++) { // Checks every row in the array
//	        Total = 0;
//	        for(int column = 0; column < array[row].length; column++) { //Check every element in the array
//	            if(column != row) { //In case an element does not found diagonally
//	                Total += Math.abs(array[row][column]); //Calculates the total
//	            }
//	        }
//	        if(Math.abs(array[row][row]) < Total) { //In case the element that was found diagonally is less than the total
//	            return false; //In case the array isn't diagonally dominant, than return miss
//	        }
//	    }
//	    return true; //Else return hit
//	}
//	//Simulation of a game.
//	public int[] found_ship(int x, int y, Board board) {
//		
//		int[] result = new int[4];
//		result[0] = x;
//		result[1] = y;
//		int hit_number = 0;
//		board.Shot(x, y);
//		
//		for(int i = 0; i < 5; i++) {  //If it a hit, look to the left to check for another hit
//			if (y-i > 0 && board.Shot(x, y-i)) {
//				hit_number++;
//				result[2] = x;
//				result[3] = y-i;
//			}
//			else {
//				break;
//			}
//		}
//		for(int i = 0; i < 5; i++) {  //If it a hit, look up to check for another hit
//			if (x+i < board.getWidth() && board.Shot(x+i, y)) {
//				hit_number++;
//				result[2] = x+i;
//				result[3] = y;
//			}
//			else {
//				break;
//			}
//		}
//		for(int i = 0; i < 5; i++) {  //If it a hit, look to the right to check for another hit
//			if (x-i > 0 && board.Shot(x-i, y)) {
//				hit_number++;
//				result[2] = x-i;
//				result[3] = y;
//			}
//			else {
//				break;
//			}
//		}
//		for(int i = 0; i < 5; i++) {  //If it a hit, look down to check for another hit
//			if (y+i < board.getHeight() && board.Shot(x, y+i)) {
//				hit_number++;
//				result[2] = x;
//				result[3] = y+i;
//			}
//			else {
//				break;
//			}
//		}
//		if (hit_number == 5) {
//			result[4] = 0;
//		}
//		else {
//			result[4] = 1;
//		}
//	return result;
//	}
//}