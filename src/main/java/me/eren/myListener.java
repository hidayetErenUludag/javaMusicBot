package me.eren;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

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
            songName = searchQuery; // the code returns the name of the song to be used in the AudioPlayerSendHandler.java
        }
        Guild guild = event.getGuild();
        VoiceChannel channel = guild.getVoiceChannelsByName("music", true).get(0);
        AudioManager manager = guild.getAudioManager();
        manager.setSendingHandler(new DefaultAudioPlayerManager());
        manager.openAudioConnection(channel);

    }

    public String getSongName() {
        return songName;
    }
}