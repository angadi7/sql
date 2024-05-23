package stringop;

public class StringOperations {

    public static String concatenateReverseExtract(String str1, String str2, int length) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";

        
        String concatenated = str1 + str2;

        
        String reversed = new StringBuilder(concatenated).reverse().toString();

        
        if (length > reversed.length()) {
            return reversed; 
        }

        
        int start = (reversed.length() - length) / 2;

        
        return reversed.substring(start, start + length);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(concatenateReverseExtract("hello", "world", 5)); 
        System.out.println(concatenateReverseExtract("", "abc", 2)); 
        System.out.println(concatenateReverseExtract("abc", "", 1)); 
        System.out.println(concatenateReverseExtract("java", "programming", 3)); 
        System.out.println(concatenateReverseExtract("test", "case", 20)); 
    }
}
