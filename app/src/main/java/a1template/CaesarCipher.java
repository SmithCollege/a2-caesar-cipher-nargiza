package a1template;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /** Private offset that tracks how many positions to shift the index for
     * this cipher 
     */
    private int offset;

    /** Constructor that should define the instance variables, including
     * populating the alphabet.
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset){
        this.offset = offset;
        // Create and populate the alphabet array (letters a to z)
        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char)('a' + i);
        }
        // Determine the effective offset for the cipher.
        // We want cipher[i] to return alphabet[(i - offset) mod 26].
        // Since DynamicArray's get(i) returns underlying[(i + defaultOffset) mod length],
        // we set defaultOffset = (26 - offset mod26) mod26.
        int effectiveOffset = (26 - (offset % 26)) % 26;
        this.cipher = new DynamicArray<Character>(effectiveOffset, this.alphabet);
    }

    /** Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value.
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val){
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        }
        return -1; // or throw an exception if desired
    }

    /** Encode a message using the cipher.
     * For each lowercase letter, find its index in the alphabet and then
     * substitute it with the letter stored in cipher at that index.
     * Non-letter characters are left unchanged.
     * @param message message to encode
     * @return encoded message
     */
    public String encode(String message){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z'){
                int index = findIndex(c);
                // Use the DynamicArray's get(index) method which uses our shifted view
                char encodedChar = cipher.get(index);
                sb.append(encodedChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
     }

    /** Decode a message using the cipher.
     * Here we reverse the process. Since our encoding does:
     *    encoded = alphabet[(originalIndex - offset) mod 26]
     * we can recover the original letter by computing:
     *    originalIndex = (findIndex(encoded) + offset) mod 26.
     * Non-letter characters are left unchanged.
     * @param message message to decode
     * @return decoded message
     */
    public String decode(String message){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z'){
                int encodedIndex = findIndex(c);
                int originalIndex = (encodedIndex + offset) % 26;
                char decodedChar = alphabet[originalIndex];
                sb.append(decodedChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /** Provide a get method that delegates to the cipher DynamicArray.
     * This is used for testing the shifted alphabet.
     * @param i index to retrieve
     * @return the Character at that index in the cipher array.
     */
    public Character get(int i) {
        return cipher.get(i);
    }

    public static void main(String[] args) {

        
         
    }
}
