// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
		iterationCounter= 0;
		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), te number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double endBalance= loan;
		for(int i=0;i<n;i++){
		 endBalance= (endBalance - payment)*(1+rate/100);
		}
		return endBalance;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double endbalance1= loan;
		double payment1=loan/n;
		while (endbalance1>epsilon)  {
			 endbalance1= loan;
			iterationCounter++;

			for(int i=0;i<n;i++){
				endbalance1= (endbalance1 - payment1)*(1+rate/100);	
			}
			if(endbalance1>epsilon){
				payment1+=0.01;
				 
		
			}



		}
		return payment1 ;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double endbalance2= loan;
		double low = 0.0;
		double hight= loan;
		double payment2= (low+hight)/2;
		


		while ((endbalance2>epsilon && endbalance2>0)  )  {
			
		 endbalance2= loan;
			iterationCounter++;
			for(int i=0;i<n;i++){
				endbalance2= (endbalance2 - payment2)*(1+rate/100);	
			}
			if(endbalance2>epsilon){
				low= payment2; 
			}else if(endbalance2<epsilon){
				hight=payment2;
			}
			payment2= (low+hight)/2.0;
			
    }
	return payment2;
}
}