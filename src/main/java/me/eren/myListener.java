package me.eren;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class myListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
            return; // Ignore messages sent by the bot itself
        }

        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getChannel());

        if (event.getMessage().getContentRaw().toLowerCase().equals("ping")) {
            event.getChannel().sendMessage("Pong").queue();
        } else if (event.getMessage().getContentRaw().toLowerCase().equals("pong")) {
            event.getChannel().sendMessage("Ping").queue();
        }
    }
}