/*
* Friends School adaptation of a lab by Robert Sedgewick described at
* https://introcs.cs.princeton.edu/java/24percolation/
*
*
* (c) 2021 Joel Hammer, Friends School of Baltimore.
*/


/**
* This interface describes the required methods for a percolation system made up of a
* grid of n x n sites, all initially closed. These sites may be sequentially
* opened (but never closed). It considers that water flows from the top of the grid
* and detects:
* <ol type = "1">
* <li> Whether water flows to any given site from the top and </li>
* <li> Whether the system percolates. That is, water can flow from
* the top through open sites to the bottom of the system </li></ol>
*
*<p>Water can flow from one site to the next <b> only </b> if they share a border, so
* that water cannot pass directly between two squares joining only at the corner.
*
* <p>The entire system is said to percolate if a path of open sites (that is, where water
* can flow from one site to the next) exists from an open site on the top row to an
* open site on the bottom row.
*
* <p>An ideal implementation of this method will avoid the problem of "backwashing" or
* "backflow." Namely, when a system percolates, a site wich has no path to the top row
* does not fill with water even if it does have a path to the bottom row. Some (less
* ideal) implementations allow water to flow back through the bottom row after
* percolation and into sites which otherwise would not have contained water.
*/
public interface Percolator {
	
	/**
	* Opens the site at the given row column in the percolation matrix.
	*
	* @param row the row in which the site to be opened is located. Rows, by
    * convention begin with the uppermost row being numbered "1."
	* @param col the column in which the site to be opened is located.Columns,
    * by convention, begin with the leftmost column being numbered "1."
	*/
	public void open(int row, int col);
	
	
	/**
	* Checks whether a given site is open.
    *
    * @param row the row in which the site to be checked is located. Rows, by
    * convention begin with the uppermost row being numbered "1."
    * @param col the column in which the site to be checked is located. Columns,
    * by convention, begin with the leftmost column being numbered "1."
    * @return {@code true} if the given site is open and {@code false} otherwise.
	*/
	public boolean isOpen(int row, int col);
	
	/**
    * Determines whether a given site has filled with water. In other words, this
    * method will return {@code true} if there is a path from an open site in the top
    * row to the given one.
    *
    * @param row the row in which the site to be checked is located. Rows, by
    * convention begin with the uppermost row being numbered "1."
    * @param col the column in which the site to be checked is located. Columns,
    * by convention, begin with the leftmost column being numbered "1."
    * @return {@code true} if a path exists between an open top-row site and
    * the given site, {@code false} otherwise.
    */
    public boolean hasWater(int row, int col);
	
	/**
    * Determines if the system percolates. By definition, a system percolates if
    * there exists a path of open sites from an open site on the top row to an open
    * site on the bottom.
    *
    * @return {@code true} if the system percolates.
    */
    public boolean percolates();
	
	/**
	* Gives the number of sites that have been opened.
	*
	* @return The number of sites open in the percolation system.
	*/
	public int numberOfOpenSites();
	
}
