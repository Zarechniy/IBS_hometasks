import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, EmptyFileException {

        //имя файла text.txt - лежит в корне проекта

        String[] list;
        Path file;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = Path.of(reader.readLine());
        }

        StringBuilder builder = new StringBuilder();
        try(FileReader fileReader = new FileReader(file.toAbsolutePath().toString())) {
            if (fileReader.read() == -1) {
                throw new EmptyFileException();
            } else {
                while (fileReader.ready()) {
                    char currentChar;
                    currentChar = (char) fileReader.read();
                    builder.append(currentChar);
                }
            }
        }

        String newString = builder.toString().replaceAll("\\p{Punct}", " ").replaceAll("\\s", " ");
        if (!newString.contains("[a-zA-Z]+")) {
            throw new EmptyFileException();
        }

        String delimiter = " ";
        list = newString.split(delimiter);

        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(list));
        String delimiter2 = "";
        wordList.removeIf(e -> e.equals(delimiter2));
        Collections.sort(wordList);
        System.out.println("Обработанный список слов: " + "\n" + wordList + "\n");

        Map<String, Integer> map = new HashMap<>();
        for (String temp : wordList) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }

        int size = wordList.size();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Слово: " + entry.getKey()
                    + ", Повторений: " + entry.getValue()
                    + "\n" + "Оно встречается в " + (entry.getValue() * 100) / size + "% случаев" + "\n");
        }

        int maxValue = (Collections.max(map.values()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println("Чаще всего встречается " + entry.getKey() + " - " + entry.getValue() + " раза");
            }
        }
    }
}
