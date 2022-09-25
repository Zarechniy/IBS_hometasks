import com.google.gson.Gson;
import model.Shares;

import java.io.FileReader;

public class Parser {
    public Parser() {
    }

    public Shares parse() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("Shares.json")) {
            return gson.fromJson(reader, Shares.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
