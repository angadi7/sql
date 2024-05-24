package com.rabin;

public class RabinKarpAlgorithm {
    public final static int d = 256; // Number of characters in the input alphabet
    public final static int q = 101; // A prime number

    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";

        RabinKarpAlgorithm rka = new RabinKarpAlgorithm();
        rka.search(pattern, text, q);
    }

    void search(String pattern, String text, int q) {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, M-1) % q"
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern.
            // If the hash values match then only check for characters one by one
            if (p == t) {
                // Check for characters one by one
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                // if p == t and pattern[0...M-1] = text[i, i+1, ...i+M-1]
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }
}
