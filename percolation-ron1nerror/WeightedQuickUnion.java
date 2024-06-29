//create size array with everything equal to 1
//as you union place the smaller trees under the larger tree
//update size array as you go
public class WeightedQuickUnion{
	private int[] id;
	private int[] size;
	public WeightedQuickUnion(int N){
		id = new int[N];
		size = new int[N];
		for(int i=0; i <id.length; i++){
			size[i] = 1;
			id[i] = i;
		}
	}
	private int root(int i){
		while(i != id[i]){
			i = id[i];
		}
	return i;
	}
	//!!! was private but whiched to public check here first to errors
	public void union(int a, int b){
		
		if(size[root(a)] > size[root(b)]){
			id[root(b)] = id[root(a)];
			size[root(a)] += size[root(b)];
		}else{
			id[root(a)] = id[root(b)];
			size[root(b)] += size[root(a)];
		}

	}	
	
	public boolean find(int a, int b){
		return root(a) == root(b);
	}
	/*
	 public static void main(String[] args) {
		QuickUnion W = new QuickUnion(9);
		//int[] size = new int(9);
		//W.union(3,2);
		System.out.println(W.find(6,2));
		System.out.println(W.find(6,4));
    }
	*/
}