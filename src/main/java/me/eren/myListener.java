package me.eren;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Arrays;

public class myListener extends ListenerAdapter {
    public String songName;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
            return; // Ignore messages sent by the bot itself
        }
        String[] messageContent = event.getMessage().getContentRaw().split(" "); // split message by spaces

        System.out.println(messageContent[0]); // if the !play (x) is written the bot will extract the x from the command
        if (messageContent[0].equals("!play")) {
            // extract search query
            String searchQuery = String.join(" ", Arrays.copyOfRange(messageContent, 1, messageContent.length));
            System.out.println("Search query: " + searchQuery);
            songName = searchQuery; // the code returns the name of the song to be used in the player.java
        }
        // test to see if the code is running
        if (event.getMessage().getContentRaw().toLowerCase().equals("ping")) {
            event.getChannel().sendMessage("Pong").queue();// checks to see if the lower case input is equal to value
        }
        else if (event.getMessage().getContentRaw().toLowerCase().equals("pong")) {
            event.getChannel().sendMessage("Ping").queue();// checks to see if the lower case input is equal to value
        }
        System.out.println("Received message: " + event.getMessage().getContentRaw());// another test case
    }

    public String getSongName() {
        return songName;
    }
}