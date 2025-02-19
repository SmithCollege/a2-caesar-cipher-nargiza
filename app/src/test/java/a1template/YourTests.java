package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {

    @Test
    public void additionalEncodeTests() {
         // Test 1: Using offset = 5 on "hello world"
         CaesarCipher cipher1 = new CaesarCipher(5);
         // For offset=5, encoding works as:
         // 'h' -> 'c', 'e' -> 'z', 'l' -> 'g', 'l' -> 'g', 'o' -> 'j'
         // so "hello" becomes "czggj", and "world" becomes "rjmgy".
         String message1 = "hello world";
         String expectedEncoded1 = "czggj rjmgy";
         assertEquals(expectedEncoded1, cipher1.encode(message1));

         // Test 2: Using offset = 10 on "java programming"
         CaesarCipher cipher2 = new CaesarCipher(10);
         // Expected: "java" -> "zqlq" and "programming" -> "fhewhqccydw"
         String message2 = "java programming";
         String expectedEncoded2 = "zqlq fhewhqccydw";
         assertEquals(expectedEncoded2, cipher2.encode(message2));
    }

    @Test
    public void additionalDecodeTests() {
         // Test 1: Decoding the encoded message from offset = 5 should return the original.
         CaesarCipher cipher1 = new CaesarCipher(5);
         String encoded1 = "czggj rjmgy";
         String expectedDecoded1 = "hello world";
         assertEquals(expectedDecoded1, cipher1.decode(encoded1));

         // Test 2: Decoding the encoded message from offset = 10 should return the original.
         CaesarCipher cipher2 = new CaesarCipher(10);
         String encoded2 = "zqlq fhewhqccydw";
         String expectedDecoded2 = "java programming";
         assertEquals(expectedDecoded2, cipher2.decode(encoded2));
    }
}
