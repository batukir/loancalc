import java.util.Scanner;
/*
 * If users loan is greater than a year, it will calculate money owed
 * after interest rate and the monthly payment of the loan.
 * 
 * @version 05/12/19
 * @author Batuhan Kir
 * 
 */
public class Loan
{
	/**
	 * Calculate the monthly payment of a loan.
	 * 
	 * @param  loan			Loan amount that is being borrowed from the bank
	 * @param  interestRate Interest rate on the loan
	 * @param  term 		Term to repay owed money to bank
	 * @return The monthly payment of a loan given interest rate, amount and term 
	 */
	public static double getMonthlyPayment(double loan, double interestRate, double years) 
	{
		double rate = (interestRate / 100) / 12;
		double months = years* 12;
		
		if(years > 0 && interestRate < 1)
		{
			System.out.println("Calculating details on current loan...");
		}
		else
		{
			System.out.println("ERROR IN RESULT! INVALID TERM OR INTEREST RATE GIVEN.");
		}
		//Amortized Loan Payment Formula : p=a/{[(1+r)^n]-1}/[r(1+r)^n]
		double result = loan / (((Math.pow((1 + rate), months)) - 1) / (rate * (Math.pow((1 + rate), months))));
		return result;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double loan = 0;
		double interestRate = 0;
		double monthlyPayment = 0;
		double balance = 0;
		int years;
		
		System.out.println("Enter the loan amount: ");
		loan = sc.nextDouble();
		
		System.out.println("Enter the interest rate (in decimal form) on the loan: ");
		interestRate = sc.nextDouble();
		
		System.out.println("Enter the term (in years) for the loan payment: ");
		years = sc.nextInt();
		
		System.out.println("\n----------------------------------------------------");
		sc.close();

		monthlyPayment = getMonthlyPayment(loan, interestRate, years);
		balance = -(monthlyPayment * (years * 12));
		System.out.println("Amount owed to bank:" + "	" + balance);
		System.out.println("Minimum monthly payment:" + " " + monthlyPayment);
	}
}
