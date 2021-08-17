
public class Printer {

	private int tonerLevel;
	private int pagesPrinted;
	private boolean duplex;
	public Printer(int tonerLevel, boolean duplex) {
		super();
		if (tonerLevel > -1 && tonerLevel <= 100) {
		this.tonerLevel = tonerLevel;
		}
		else {
			this.tonerLevel = -1;
		}
		
		this.pagesPrinted = 0;
		
		this.duplex = duplex;
	}
	
	
	public int addToner(int tonerAmount) {
		if (tonerAmount > 0 && tonerAmount <= 100 && tonerAmount + tonerLevel <= 100) {
			tonerLevel += tonerAmount;
			return tonerLevel;
		}
		else {
			return -1;
		}
		
	}
	
	public int printPages(int pages) {
		if (duplex) {
			if (pages % 2 == 0) {
				int pagesToPrint = pages / 2;
				pagesPrinted += pagesToPrint;
				return pagesToPrint;	
			}
			else {
				int pagesToPrint = pages / 2 + 1;
				pagesPrinted += pagesToPrint;
				return pagesToPrint;				
			}
		}
		else {
			int pagesToPrint = pages;
			pagesPrinted += pagesToPrint;
			return pagesToPrint;
		}
	}
	
	public int getPagesPrinted() {
		return pagesPrinted;
	}
}
