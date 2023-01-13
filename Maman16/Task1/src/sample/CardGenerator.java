package sample;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CardGenerator {
    ArrayList<String> cardsList;
    // !--Make sure to change cardPath acording to your computer file path --!
    private String cardPath = "/Users/eric/Desktop/Java-course/Maman16/Task1/src/cards";

    public CardGenerator() {
        cardsList = new ArrayList<>();

        Path dir = Paths.get(cardPath);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                cardsList.add(entry.toString());
            }
        } catch (IOException e) {
            // I/O error encounted during the iteration, the cause is an IOException
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCards(int size){
        ArrayList<String> duplicatedCardsList = new ArrayList<>();
        //Check maximum size
        if(size > 6 && size*size % 2 != 0){
            System.out.println("Maximum matrix size is 6 and has to even");
            System.exit(1);
        }

        int matSize = size * size;

    }

}
