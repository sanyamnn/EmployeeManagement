import java.util.List;

public abstract class Employee
{
    private String firstName; //Stores first name
    private String secondName; //Stores second name
    private double hourlyRate; //Stores hourly rate earned

    public final static double NORMAL_WORKWEEK = 37.5;

    public Employee(String firstName, String secondName, double hourlyRate)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        if (hourlyRate >=0) //Validation for hourly rate
        {
            this.hourlyRate = hourlyRate;
        }
        else
        {
            this.hourlyRate = 0;
        }
//		this.employeeID = employeeID;
    }


    /**
     * Returns the salary of an employee including overtime and
     * bonus if applicable for the specified number of hours worked
     *
     * @param numHours			Number of hours worked by employee
     * @return							Salary of employee (with overtime and bonus if applicable)
     */
    public double calculateSalary(double numHours)
    {
        if (numHours >= 0)
        {
            if (numHours <= NORMAL_WORKWEEK)
            {
                return ((getHourlyRate() * numHours)); //Less than standard hours
            }
            else
            {
                return ((getHourlyRate() * NORMAL_WORKWEEK) + calculateOvertime(numHours)); //Maximum standard rate
            }
        }
        else
        {
            return 0.0;

        }

    }

    /**
     * Returns overtime of employee
     * @param numHours    Hours worked
     * @return						Overtime
     */
    private double calculateOvertime (double numHours)
    {

        if (numHours >= NORMAL_WORKWEEK)
        {
            return ((numHours - NORMAL_WORKWEEK) * (2 * getHourlyRate())); //Overtime calculated with double of standard rate
        }
        else
        {
            return 0.0;
        }

    }

    /**
     * Create a String with the generic employee details
     */
    public String toString()
    {
        String list = "";
        list += ("\nFirst name: " + getFirstName() +
                "\nSecond name: " + getSecondName() +
                "\nHourly rate: " + getHourlyRate());
        return list;
    }

    /**
     * Setters and getters
     */
    public String getFirstName()
    {
        return firstName;
    }
    public String getSecondName()
    {
        return secondName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    public void setHourlyRate(double newRate)
    {
        if (newRate >= 0)
        {
            this.hourlyRate = newRate;
        }
    }


}
