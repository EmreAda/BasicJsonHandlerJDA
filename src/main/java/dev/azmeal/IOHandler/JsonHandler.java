package dev.azmeal.IOHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonHandler {
    public enum Data {
        TOKEN, OWNERID, PREFIX
    }

    private final String PATH;
    public JsonHandler(String path) {
        PATH = path;
    }



    public String getData(Data data) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        Reader reader = new FileReader(PATH);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        String dataToReturn;
        switch (data) {
            case TOKEN:
                dataToReturn = (String) jsonObject.get("token");
                //return (String) jsonObject.get("token");
                break;
            case OWNERID:
                dataToReturn = (String) jsonObject.get("ownerid");
                //return (String) jsonObject.get("ownerid");
                break;
            case PREFIX:
                dataToReturn = (String) jsonObject.get("prefix");
                //return (String) jsonObject.get("prefix");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + data);
        }
        return dataToReturn;
    }
}
