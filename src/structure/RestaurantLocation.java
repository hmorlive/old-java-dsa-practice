package structure;

import java.util.List;

public class RestaurantLocation {
	public void findLoc(int[][] locations) {
		int profit = 0;
		int maxProfit = 0;
		int distance = 0;
		int[] combination = new int[4];
		int[] idealLocations = new int[4];
		int count = 0;
		for(int i = 0; i < locations.length; i++) {
			combination[count++] = locations[i][0];
			profit = locations[i][2];
			for (int j = i + 1; j < locations.length; j++) {
				distance += locations[j][1];
				if (distance < 10) continue;
				combination[count++] = locations[j][0];
				profit += locations[j][2];
				distance = 0;				
			}
			System.out.println(profit + " " + makeString(combination));
			if (profit > maxProfit) {
				maxProfit = profit;
				idealLocations = combination;
			}
			count = 0;
			profit = 0;
		}
		System.out.println(makeString(idealLocations));

	}
	
	String makeString(int[] locations) {
		String output = "";
		for (int i = 0; i < locations.length; i++) {
			output += locations[i];
			if (i == locations.length - 1) output += "]";
			else output += ", ";
		}
		return output;
	}
}