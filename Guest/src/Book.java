
public class Book 
{
	private String author;
	private String title;
	private int pages;
	private int curpage;
	
	//Main Function
	public static void main(String[] args)
	{
		Book b1 = new Book("2Cool2Read", "Not a book", 12);
		
		System.out.println(b1);
		System.out.println("Current Page: " + b1.getCurPage());
		
		int x = 2 + 2*b1.getCurPage();  //Since b1.getCurPage() returns an int, you cannot put it on its own line
		b1.readPages(3); //Since this is a void method, you can put it on its own line
		System.out.println("Current Page: " + b1.getCurPage());
		
		//Arraylist<Integer> test = new ArrayList<Integer>();
		
		//int val3 = test.get(3);
	}
	
	//Constructor
	public Book(String writer, String thistitle, int numpages)
	{
		author = writer;
		title = thistitle;
		pages = numpages;
		curpage = 0;
	}
	
	//Constructor
	public Book(String thistitle, int numpages)
	{
		title = thistitle;
		pages = numpages;
		curpage = 0;
		author = "Unknown";
	}
	
	// Mutator method
	// Mutates, or changes, a value within the object
	public void readPages(int numPagesToRead)
	{
		curpage += numPagesToRead;
	}
	
	// Accessor method
	// Accesses a value from the object
	public int pagesLeft()
	{
		return pages - curpage;
		
	}
	
	
	public String toString()
	{
		return title + " by " + author + ": " + pages + " pages";
	}
	
	public int getCurPage()
	{
		return curpage;
	}
	
	
	
}
