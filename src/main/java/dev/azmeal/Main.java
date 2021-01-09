package dev.azmeal;

import dev.azmeal.IOHandler.JsonHandler;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.json.simple.parser.ParseException;

import javax.security.auth.login.LoginException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ParseException, LoginException {
        JsonHandler handler = new JsonHandler("/home/azmeal/IdeaProjects/ABotWithJsonHandler/src/main/java/dev/azmeal/config.json"); //our json reader shit
        JDABuilder builder = JDABuilder.createDefault(handler.getData(JsonHandler.Data.TOKEN)); //bot builder, i guess
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE); //same as down
        builder.setBulkDeleteSplittingEnabled(false); //some code i copied from official docs
        builder.setCompression(Compression.NONE); //same
        builder.setActivity(Activity.watching("You!")); //status
        builder.build(); //finally
    }
}
