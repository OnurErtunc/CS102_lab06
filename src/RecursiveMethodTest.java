import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Onur Ertunc
 * @version 10.12.2020
 */
public class RecursiveMethodTest {

    public static void main( String[] args ) {

        // Scanner
        Scanner scan = new Scanner( System.in );

        // Variables
        int lengthOfBitString;

        // Question 1
        // Count the length of the string
        // Input: "CS101 is the best"
        System.out.println( "Input: CS102 is the best" );
        System.out.println( "Output: " + recursiveLength( "CS102 is the best" ) );
        System.out.println();

        // Question 2
        // find the number of non-vowels in a given array of characters / string using
        // recursion. We do not care about the case (uppercase or lowercase) in this problem.
        // Input: "CS102 is a good course"
        System.out.println( "Input: CS102 is a good course" );
        System.out.println( "Output: " + countOfNonVowels( "CS102 is a good course" ) );
        System.out.println();

        // Question 3
        // generate all binary strings of length n (that is your input) without 1's that come
        // together using recursion
        System.out.print( "Input: " );
        lengthOfBitString = scan.nextInt() - 1;
        System.out.println( "Output: " );
        onesNotTogether( lengthOfBitString, "0" );
        onesNotTogether( lengthOfBitString, "1" );
        System.out.println();

        // Question 4
        // Write a recursive method to find the number of files on your computer's disk for a given directory.
        // Note that a directory may also contain subdirectories
        final String PATH = "C:\\Users\\User\\Desktop\\eng102_research-paper_documents";
        File directory = new File( PATH );
        System.out.println( "Number of files in given directory: " + numberOfFiles( directory ) );
    }

    /**
     * finds the length of a string with recursion
     * @param str String
     * @return length of the string
     */
    public static int recursiveLength( String str ) {

        if ( str.length() == 0 ) {
            return 0;
        }
        return recursiveLength( str.substring( 1 ) ) + 1;
    }

    /**
     * counts the number of non-vowels in a string
     * @param str String
     * @return number of non-vowels
     */
    public static int countOfNonVowels( String str ) {

        str = str.toLowerCase();

        if ( str.length() == 0 ) {
            return 0;
        }
        if ( str.charAt( 0 ) != 'a' && str.charAt( 0 ) != 'e' && str.charAt( 0 ) != 'i' && str.charAt( 0 ) != 'o' &&
                str.charAt( 0 ) != 'u' && str.charAt( 0 ) != '0' && str.charAt( 0 ) != '1' && str.charAt( 0 ) != '2' &&
                str.charAt( 0 ) != '3' && str.charAt( 0 ) != '4' && str.charAt( 0 ) != '5' && str.charAt( 0 ) != '6' &&
                str.charAt( 0 ) != '7' && str.charAt( 0 ) != '8' && str.charAt( 0 ) != '9' && str.charAt( 0 ) != ' ' ) {
            return countOfNonVowels( str.substring( 1 ) ) + 1;
        }
        return countOfNonVowels( str.substring( 1 ) );
    }

    /**
     * generates and prints strings that do not have consecutive 1's
     * @param n length of the string
     * @param str string
     */
    public static void onesNotTogether( int n, String str ) {

        boolean stack = true;
        if ( n == 0 ) {
            stack = false;
            System.out.println( str );
        }
        if ( (str.charAt( str.length() - 1 ) == '0') && stack ) {
            String str1 = str;
            str1 = str1 + '1';
            String str2 = str;
            str2 = str2 + '0';
            onesNotTogether( n-1, str1 );
            onesNotTogether( n-1, str2 );
        }
        if ( (str.charAt( str.length() - 1 ) == '1') && stack ) {
            String str3 = str;
            str3 = str3 + '0';
            onesNotTogether( n-1, str3 );
        }
    }

    /**
     * counts the files in a given directory. subdirectories are included
     * @param file object keeps directory
     * @return number of files and subdirectories in directory
     */
    public static int numberOfFiles( File file ) {

        File[] files = file.listFiles();
        int count = 0;
        if (files != null) {
            for ( File i: files ) {
                if ( i.isDirectory() ) {
                    count = count + numberOfFiles( i );
                }
                count++;
                if ( !i.isFile() ) {
                    count--;
                }
            }
        }

        return count;
    }
}
