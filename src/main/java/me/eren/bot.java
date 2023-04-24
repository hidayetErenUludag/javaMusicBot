package me.eren;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class bot{
    static final Map<String, command> commands = new HashMap<>();

    public static void main(String[] args) throws LoginException {
        JDA myBot = JDABuilder.createDefault("MTA5OTc2OTI0NjAwOTAxMjI2NA.GKSHPc.8yLcB0biSJELav3JcYdfB1BzbQvLOQui1-xxrs")
                .setActivity(Activity.playing("with my life"))
                .addEventListeners(new myListener())
                .build();
        System.out.println("Hello");
    }
}
