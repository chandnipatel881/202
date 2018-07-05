/**
 *	SearchArray implements a linear search in an array, searching
 *	for a user provided value.
 *
 *	Class Invariants:
 * 	'maxVal' must be greater than 'minVal'
 *	All elements of the array must lie in the range defined by
 *	 	'minVal' and 'maxVal' variables
 *	@author
 *	@version Mar 3, 2012
 *	@project CMSC 202 - Spring 2012 - Project #
 *	@section #
 *
 */
public class SearchArray {
    private int array[],minVal,maxVal;
    boolean constructed=false;
    /**
     * Assigns the instance variable array reference to
     * point to the incoming array reference. Also assigns the
     * range values.
     * Precondition: The input array to the constructor cannot be null.
     * @param array The input array to be searched on.
     * @param minVal The minimum allowed value in the array.
     * @param maxVal The maximum allowed value in the array.
     */
    public SearchArray(int[] array, int minVal, int maxVal) {

        //Precondition checking code
        if(array==null){
            throw new NullPointerException("Constructor precondition " +
                    "not met: Input array cannot be null");
        }

        //class invariant #1 checking code
        if(maxVal<minVal){
            throw new RuntimeException("Class invariant " +
                    "not met: maxVal cannot be less than minVal");
        }

        for(int i : array){
            if (i < minVal || i > maxVal){
                throw new RuntimeException("Class invariant " +
                        "not met: All elements of the array must lie in the range defined by" +
                        " minVal' and 'maxVal' variables");
            }
        }

        this.array=array;
        this.minVal=minVal;
        this.maxVal=maxVal;
        constructed=true;
        System.out.println("\tSearchArray object successfully initialized");
    }


    /**
     * Method to search for a number in the array.
     * Precondition: the least possible value of x can be minVal and
     * 		the max possible value can be maxVal.
     * @param x The number to be searched
     */
    public void search(int x){
        if(constructed){
            /*
             * Enter Pre-condition checking code here
             */
            if (x < minVal || x > maxVal){
                throw new RuntimeException("Search method precondition " +
                        "not met : the least possible value of x can be minVal and" +
                        "the max possible value can be maxVal.");
            }

            boolean found=false;
            int i=0;
            while(found==false){
                if(array[i]==x){
                    found=true;
                }
                i++;
            }
            if(found==true){
                System.out.println("\tElement " + x + " found at position " + --i);
            }else
                System.out.println("\tElement " + x + " not found");
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        SearchArray s;

        /*
         *test case to check class invariant #2
         */
        /*
        System.out.println("Passing elements of array less than 1 and greater than 10 Expecting error statement.");
        int[] testArray1={1,2,-3,4,11};
        s=new SearchArray(testArray1, 1, 10);
        */

        //test case to check class invariant#1
        /*
		System.out.println("Passing minVal>maxVal. Expecting error statement.");
		int[] testArray1={1,2,3,4,5};
		s=new SearchArray(testArray1, 10, 9);
        */

        //test case to check constructor precondition
        /*
		System.out.println("Passing null array. Expecting error statement.");
		int[] testArray2=null;
		s=new SearchArray(testArray2, 0, 100);
        */

        //test case to check edge values of the constructor
        /*
        System.out.println("Edge case for constructor. Array values " +
                "exactly on range limits");
        int[] testArray3={-5,-9,0,-1,3,6,7,-2,2};
        s=new SearchArray(testArray3, -9, 7);
        */
        //test case to check general values of the constructor
        System.out.println("General test case for constructor");
        int[] testArray4={5,-6,0,-1,3,6,7,-2,2,3,4,7,-8};
        s=new SearchArray(testArray4, -9, 10);

        /*
         * General test case(s) for search()
         */
        s.search(0);

        /*
         * Precondition checking test case for search()
         */
        //s.search(-12);

        /*
         * Edge test case for search()
         */
        System.out.println("Edge case for constructor. Array values " +
                "exactly on range limits");
        int[] testArray3={-5,-9,0,-1,3,6,7,-2,2};
        s=new SearchArray(testArray3,-9,7);

    }

}