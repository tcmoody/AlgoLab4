
public class Dedupe {
	
	public static void main(String [] args) throws CloneNotSupportedException  {
		generatePostsWithDupes(10, .2);	
	}
	
	
	/**
	 * 
	 * @param N size of Post array
	 * @param percentage the percentage of entries that should be a duplicate of some other entry
	 * @return list of array containing duplicates.
	 */
	public static Post [] generatePostsWithDupes(int N, double percentage) throws CloneNotSupportedException {
		int numDuplicates = (int) (percentage*N);
		Post[] postWithoutDupes;
		postWithoutDupes = generatePosts(N-numDuplicates);
		Post[] postWithDupes = new Post[N];
		Post temp = null;
		for(int i=0; i<N; i++){
			if(i>=postWithoutDupes.length){
				temp = (Post) postWithoutDupes[N-i].clone();
				postWithDupes[i]=temp;
			}else{
			postWithDupes[i] = postWithoutDupes[i];
			}
		}
		return postWithDupes;
	}
	
	/**
	 * shuffles an array of posts
	 * 
	 * @param arr
	 */
	public static void shuffle(Post [] arr) {
		// knuth shuffle
		for(int i=0;i<arr.length;i++) {
			Post tp = arr[i];
			int rnd = StdRandom.uniform(i,arr.length);
			arr[i]=arr[rnd];
			arr[rnd]=tp;	
		}
	}
	
	
	/**
	 * generates a random set of Posts
	 * @param N size of set
	 * @return array of posts  (the set)
	 */
	public static Post [] generatePosts(int N) {
		
		if (N <= 0) throw new IllegalArgumentException("N must be >= 1");
		Post [] posts = new Post[N];
		for(int i=0;i<N;i++) {
			posts[i] = new Post();
		}
		
		return posts;
	}
}
