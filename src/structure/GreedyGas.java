package structure;

/** @author hazmed
 *  @version 1.0
 *  Greedy Gas - Finds farthest gas station before gas runs out.
 */
public class GreedyGas {
	int fuelTank; //Capacity of Gas Tank
	int[] gasStation; //Gas stations available
	int milesTraveled;
	
	//Initializes 
	public GreedyGas() {
		fuelTank = 250;
		gasStation = new int[] { 25, 50, 75, 100, 125, 200, 230, 275, 325, 425, 575,
								625, 670, 715, 750, 780, 815, 920, 980, 1010, 1100, 1150, 
								1250, 1300, 1500, 1550, 1750, 1870, 1920, 1980, 2000 };
	}
	
	//Runs the program
	public void run(){
		getGasNow(fuelTank, gasStation);
	}
	
	//Gets gas station farthest out within gas tank range.
	private void getGasNow(int fuel, int[] station){
		int count = 0, milesTraveled = 0;
		
		for (int i = 0; i < station.length; i++) {
			if (fuel < gasStation[i] - milesTraveled) {
				System.out.println("Stop " + ++count + ": gas station at "
								   + station[i - 1] + " miles"
						           + "\n--Miles left on tank at stop: " 
						           + (fuel - (station[i - 1] - milesTraveled)));
				milesTraveled = station[i - 1];
			}
		}
	}
}
