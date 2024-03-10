import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Question 1: Huffman Coding Algorithm
        String text = "Sample text for Huffman coding algorithm";
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        huffmanCoding.createHuffmanTree(text);
        huffmanCoding.printHuffmanCodes();
        
        // Question 2: LZW Coding Algorithm
        String input = "ABABABA";
        LZWEncoding lzwEncoding = new LZWEncoding();
        lzwEncoding.createDictionary(input);
        lzwEncoding.compressInput(input);
    }
}
