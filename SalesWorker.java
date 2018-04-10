public class SalesWorker extends Employee
{

    private double salesBonus; //Stores the sales performance  bonus

    /**
     * Constructor for objects of class Manager
     *
     * @param firstName		First name of a sales worker
     * @param secondName	Second name of a sales worker
     * @param hourlyRate  Hourly rate of a sales worker
     * @param salesBonus  Sales performance bonus
     */
    public SalesWorker(String firstName, String secondName, double hourlyRate, double salesBonus)
    {
        super(firstName, secondName, hourlyRate);

        if (salesBonus >= 0 && salesBonus <= 20) //Validation for sales performance bonus
        {
            this.salesBonus = salesBonus;
        }
        else
        {
            this.salesBonus = 0;
        }
    }

    /**
     * Calculates and returns  salary of sales worker with bonus
     */
    public double calculateSalary(double numHours)
    {
        if (numHours > 0)
        {
            return super.calculateSalary(numHours) + calculateBonus(numHours);
        }
        else
        {
            return 0.0;
        }

    }

    /**
     * Calculates and returns bonus of sales worker
     */
    public double calculateBonus(double numHours)
    {
        return ((this.salesBonus/100.0) * super.calculateSalary(numHours));
    }

    /**
     * Returns a String of the sales worker's details and position
     */
    public String toString()
    {
        return "\nPostion: Sales Worker\n" +
                super.toString() +
                "\nSales bonus: " +
                salesBonus + "%";
    }


    /**
     * Setters and getters
     */
    public double getBonus()
    {
        return salesBonus;
    }

    public void setBonus(double newBonus)
    {
        if (newBonus >= 0 && newBonus <= 20)
        {
            this.salesBonus = newBonus;
        }
    }

}
