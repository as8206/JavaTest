import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project1B
{
	public static final int EMPTY = -1;
	
    static String subsequence, sequence;
    static int memo[][];
    
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String takenString;
        takenString = new String(reader.readLine());
        int numOfPairs;
        numOfPairs = Integer.parseInt(takenString);
        
        for (int i = 0; i < numOfPairs; i++)
        {
        	sequence = new String(reader.readLine());
        	subsequence = new String(reader.readLine());
        	System.out.println(answer());
        	/*
        	 * remove this
	        	 */
	        for(int x = 0; x < subsequence.length(); x++)
	        {
	        	for(int j = 0; j < sequence.length(); j++)
	        		System.out.print(memo[x][j] + "\t");
	        	System.out.println();
	        }
        }
    }


    public static int answer()
    {
    	int subLastIndex = subsequence.length() - 1;
        int seqLastIndex = sequence.length() - 1;
        memo = new int[subLastIndex+1][seqLastIndex+1];
        
        for (int k=0;k<subLastIndex+1;k++)
        	for (int j=0;j<seqLastIndex+1;j++)
        		memo[k][j] = EMPTY;
        
        return memoCheck(subLastIndex, seqLastIndex);
    }
    
    private static int memoCheck(int curSubIndex, int curSeqIndex)
    {
        if (curSubIndex == -1)
        	return 1;
        
        if (memo[curSubIndex][curSeqIndex] == EMPTY)
        	memo[curSubIndex][curSeqIndex] = fillMemo(curSubIndex, curSeqIndex);
        
        return memo[curSubIndex][curSeqIndex];
    }

    /**
     * @param curSubIndex
     * @param curSeqIndex
     * @return
     */
    private static int fillMemo(int curSubIndex, int curSeqIndex)
    {
        if (curSubIndex == -1)
        	return 1;
        if (curSubIndex > curSeqIndex)
        	return 0;
        if (curSubIndex == curSeqIndex)
        {
        	if (checkMatching(curSubIndex))
        		return 1;
        	return 0;
        }
        if (subsequence.charAt(curSubIndex) == sequence.charAt(curSeqIndex))
        {
        	/*
        	 * If a match is found, recursively call both possible options to test all possibilities
        	 */
        	return (memoCheck(curSubIndex - 1, curSeqIndex - 1))
        			+ memoCheck(curSubIndex, curSeqIndex - 1);
        }
        return (memoCheck(curSubIndex, curSeqIndex - 1));
    }
    /**
     * 
     * @param length
     * @return
     */
    private static boolean checkMatching(int length)
    {
        for (int i = 0; i <= length; i++)
        	if (subsequence.charAt(i) != sequence.charAt(i))
        		return false;
        return true;
    }

}
