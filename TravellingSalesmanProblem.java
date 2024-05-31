import java.util.ArrayList;
import java.util.collections;
import java.util.List;
import java.util.stream.collectors;
import java.util.stream.IntStream;

public class TravellingSalesmanProblem{
	private static final int startingIndex;
	private static final int[][] arr = {{0, 10, 15, 20}, {5, 0, 9, 10}, {6, 13, 0, 12}, {8, 8, 9, 0}};
	
	static{
		startingIndex = 0;
	}
	
	private static int getMinimumCost(int i, List<Integer> list){
		if (list.isEmpty()){
			return arr[i][startingIndex];
		}else{
			List<Integer> costs = new ArrayList<>();
			for (int j: list) {
				List<Integer> remaining = new ArrayList();
				for (int k: list) {
					if (j != k) {
						remaining.add(k);
					}
				}
				
				costs.add(arr[i][j] + getMinimumCost(j, remaining));
			}
			return collections.min(costs);
		}
	}
	
	public static void main(String[] args){
		System.out.println(getMinimumCost(0, IntStream.of(1, 2, 3).boxed().collect(collectors.toList())));
	}
	
}