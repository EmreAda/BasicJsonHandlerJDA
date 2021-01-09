package dev.azmeal.IOHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonHandler {
    public enum Data { //datas u gonna return. you can add more
        TOKEN, OWNERID, PREFIX
    }

    private final String PATH;
    public JsonHandler(String path) { //we need files path. right?
        PATH = path;
    }



    public String getData(Data data) throws IOException, ParseException {
        JSONParser parser = new JSONParser(); //i think we gonna parse some shit

        Reader reader = new FileReader(PATH); //i think we gonna parse this shit
        JSONObject jsonObject = (JSONObject) parser.parse(reader); //omg! we actually did it

        String dataToReturn; //we gonna return this variable
        switch (data) {
            case TOKEN:
                dataToReturn = (String) jsonObject.get("token"); //i couldnt manage to return from just swtich it requires also from outside 
                break;
            case OWNERID:
                dataToReturn = (String) jsonObject.get("ownerid"); //same
                break;
            case PREFIX:
                dataToReturn = (String) jsonObject.get("prefix"); //same
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + data); //dunno what is this bitch. ide added but i think it is for unexpected params
        }
        return dataToReturn; //finally, some fuking good data
    }
}
