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
        JsonHandler handler = new JsonHandler("/home/azmeal/IdeaProjects/ABotWithJsonHandler/src/main/java/dev/azmeal/config.json");
        JDABuilder builder = JDABuilder.createDefault(handler.getData(JsonHandler.Data.TOKEN));
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setCompression(Compression.NONE);
        builder.setActivity(Activity.watching("Seni"));
        builder.build();
    }
}
