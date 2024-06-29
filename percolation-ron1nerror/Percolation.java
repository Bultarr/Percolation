/*
wieghtedQuickFind my find;
boolean[] system 
percolator(int + n )
my find = new find
for(i;system)
	boolean[i] = false;

Variance-
V = (xj-x)^2
*/

public class Percolation implements Percolator {
	boolean[] box;
	WeightedQuickUnion x;
	int n;
	public Percolation(int n){
		box = new boolean[n*n +2];
		
		this.n = n;
		x = new WeightedQuickUnion(n * n +2);
		
		//starts by creating a board with all the boxes closed
		for(int i=0; i <box.length; i++){
			box[i] = false;
		}
		//TODO: Constructor for an n-by-n grid.
		
		//connect top and bottom rows to the +2
	}
	
	//@Override angry at override
	public int getI(int row, int col){
		return n * row + col;
	}
	/*
	//@Override angry at override
	public void getRow(int i){
		return i / n;
		
	}
	//@Override angry at override
	public void getCol(int i){
		return i % n;
	}
	*/
	@Override
	public void open(int row, int col) {
		
		box[getI(row, col)] = true;
		//connects with first ghost nod
		if(row == 0){
			x.union(getI(row, col), n*n);
		}
		//connects with last ghost nod
		if(row == n-1){
			x.union(getI(row, col), n*n + 1);
		}
		//union wit box to above
		if(row !=0 && box[getI(row-1, col)]){
			x.union(getI(row, col),getI(row-1, col));
		}
		//union wit box to below
		if(row !=n-1 && box[getI(row+1, col)]){
			x.union(getI(row, col),getI(row+1, col));
		}
		//union wit box to left
		if(col !=0 && box[getI(row, col-1)]){
			x.union(getI(row, col),getI(row, col-1));
		}
		//union wit box to right
		if(col !=n-1 && box[getI(row, col+1)]){
			x.union(getI(row, col),getI(row, col+1));
		}
	}
	
	@Override 
	public boolean isOpen(int row, int col) {
		return box[getI(row, col)];
		//TODO: Implement this method.
		
	}
	
	@Override
	public boolean hasWater(int row, int col) {
		
		//looks at the location and first ghost nod
		return(x.find(getI(row,col),n*n));
		//TODO: Implement this method.
	}
	
	@Override
	public boolean percolates() {
		
		//looks at the first and last ghost nod
		return(x.find(n*n, n*n + 1));
		//TODO: Implement this method.
		
	}
	
	@Override
	public int numberOfOpenSites() {
		int count = 0;
		for(int i=0; i<box.length-2; i++){
			if(box[i] == true){
			count++;
			}
		}
		return count;
		//TODO: Implement this method
		
	}
	
	public static void main(String[] args) {
	
	//thrre lines of code
	//print stats obj
	//print mean
	//print standard deveation
	Percolation p = new Percolation (5);
	p.open(0,0);
	p.open(1,0);
	p.open(2,0);
	p.open(3,0);
	p.open(4,0);
	p.open(5,0);
	System.out.println(p.isOpen(0,0));
	System.out.println(p.hasWater(1,0));
	System.out.println(p.percolates());
	System.out.println(p.numberOfOpenSites());
	
	
		//TODO: Test your implementation!
		
	}
	
}