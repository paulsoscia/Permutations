import java.util.HashSet;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			String s = "01";
	        //printPermutn(s, "");
			//System.out.println("");
			
	        s = "abc";
		    //printPermutn(s, "");
		    //System.out.println("");
			
	        s = "X--------";
	        Set<String> sSet = permutationFinder(s);
	        String sPerms = sSet.toString();
	        sPerms = sPerms.replace("[", "{\"");
	        sPerms = sPerms.replace("]", "\"}");
	        sPerms = sPerms.replace(",", "\",\"");
	       
	        System.out.println(sSet);
	        System.out.println(sPerms);
		    System.out.println("");
		    System.out.println("done");
			
		    
	}
	
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        
        if (str == null) {
            return null;
            // Exit condition
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
            // Exit condition 
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        
        Set<String> words = permutationFinder(rem); //recursion 
        
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                //perm.add(charInsert(strNew, initial, i));
            	perm.add( strNew.substring(0, i) + initial + strNew.substring(i) );
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        //System.out.println(begin + c + end);
        return begin + c + end;
    }

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans)
    {
 
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            // ith character of str
            char ch = str.charAt(i);
 
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
            // Recursive call
            printPermutn(ros, ans + ch);
        }
    }
 
}
