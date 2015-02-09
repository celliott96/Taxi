package mini1;

public class Taxi 
{

	private double baseFare = 0.0;

	private double perMileRate = 0.0;

	private double meterAmount = 0.0;

	private double currentRate = 0.0;

	private double cashCollected = 0.0;

	//private int miles = 0;

	private double totalMiles = 0.0;
	
	private double billedMiles = 0.0;
	
	private double unBilledMiles = 0.0;
	
	private int rideStarted = 0;

	// private double meterAmount = 0;

	public Taxi(double givenBaseFare, double givenPerMileRate) 
	{
		baseFare = givenBaseFare;
		perMileRate = givenPerMileRate;
	}
	
	//Drives the taxi, updating totalMiles and meterAmount
	public void drive(double miles) 
	{
		if(rideStarted == 0){
			unBilledMiles = miles;
		}
		else if(rideStarted == 1){
			billedMiles = miles;
		}
		totalMiles = (unBilledMiles + billedMiles);
		meterAmount = (billedMiles * perMileRate); // maybe switch totalMiles for miles
	}

	//Ends the taxi ride. Updating the 
	public void endRide() 
	{
		cashCollected = (meterAmount + baseFare);
		// resets the meter
		meterAmount = 0;
		// resets the current rate
		currentRate = 0;
	}

	public double getAverageIncomePerMile() 
	{
		double averageIncome = (cashCollected / totalMiles);
		return averageIncome;
	}

	public double getCurrentRate() 
	{
		//currentRate = perMileRate;
		return currentRate;
	}

	public double getMeter() 
	{
		return meterAmount;
	}

	public double getTotalCash() 
	{
		return cashCollected;
	}

	public double getTotalMiles() 
	{
		return totalMiles;
	}

	public void startRide() 
	{
		rideStarted = 1;
		// sets meter to base fare
		meterAmount = baseFare;
		//meterAmount = 0.0;
		// sets current rate to the per mile rate
		currentRate = perMileRate;
	}

}
