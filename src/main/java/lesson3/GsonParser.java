package lesson3;

import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class GsonParser {

    public Root parse() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("Shares.json")) {
            Root root = gson.fromJson(reader, Root.class);
            return root;
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }
        return null;
    }
}

