import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZWEncoding {
    private Map<String, Integer> dictionary;
    private List<Integer> compressedOutput;

    public void createDictionary(String input) {
        dictionary = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            String symbol = Character.toString(input.charAt(i));
            if (!dictionary.containsKey(symbol)) {
                dictionary.put(symbol, dictionary.size() + 1);
            }
        }
    }

    public void compressInput(String input) {
        compressedOutput = new ArrayList<>();
        
        int nextIndex = dictionary.size() + 1;
        String currentSymbol = Character.toString(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            String nextSymbol = Character.toString(input.charAt(i));
            String currentSequence = currentSymbol + nextSymbol;

            if (dictionary.containsKey(currentSequence)) {
                currentSymbol = currentSequence;
            } else {
                compressedOutput.add(dictionary.get(currentSymbol));
                dictionary.put(currentSequence, nextIndex++);
                currentSymbol = nextSymbol;
            }
        }

        compressedOutput.add(dictionary.get(currentSymbol));

        System.out.println("Compressed Output:");
        for (int code : compressedOutput) {
            System.out.print(code + " ");
        }
    }
}
