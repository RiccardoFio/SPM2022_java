package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeTest {
    @ParameterizedTest
    @ValueSource(strings = {"pippo", "racecar", "radar", "able was i ere i saw elba"})
    public void palindromeTest(String Candidate){
        assertTrue(Palindrome.isPalindrome(Candidate));
    }
}
