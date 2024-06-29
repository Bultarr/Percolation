/* while(!P percolates())
	randrow = math.random()*n
	randcol = math.random()*n
	p.open(randrow,randcol)
	stuff above goes in "public PercolationStats(int n, int trials)"
	
*/
public class PercolationStats {
	Percolation pt;
    double D;
	double average;
	int[] TotalTrials;
	//int[] Totaltrials; 
	//int trials = n;
    /** Perform a given number of trials on an n-by-n system. */
    public PercolationStats(int n, int trials) {
		//TotalTrials = new int[trials];
		average = 0; 
		double[] Devs = new double[trials];
		
		for(int i =0; i<trials; i++){
			Percolation pt = new Percolation(n);
			while(!pt.percolates()){
				int randrow = (int) (Math.random()*n);
				int randcol = (int) (Math.random()*n);
				pt.open(randrow,randcol);
			}
			Devs[i] = (double) pt.numberOfOpenSites() / (n*n);
			average += (double) pt.numberOfOpenSites() / (n*n);
		}
		average /= trials;
			for (int i=0; i < trials; i++){
				//squaring this to the second
				D += Math.pow (Devs[i]-average, 2);
			}
			//performs square root D divided by n
		D = Math.pow(D/n, 0.5);
	}
    
    /** The sample mean of the percolation threshold */
    public double mean() {
		//add them all up and divide by how many there are
		return average;
	}

    
    /** Standard deviation of samples of perc. threshold. */
    public double stddev() {
		return D;
	}
	
	
	public static void main(String[] args) {
		PercolationStats PS = new PercolationStats (60, 10);
		System.out.println("the mean is " + PS.mean());
		System.out.println("the deviation is " + PS.stddev());
	}
    
}