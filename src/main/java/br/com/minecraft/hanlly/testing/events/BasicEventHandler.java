package br.com.minecraft.hanlly.testing.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BasicEventHandler implements Listener {

    static private BossBar WELCOME_MESSAGE_BAR = Bukkit.createBossBar(
            ChatColor.GREEN + "Seja, bem-vindo!",
            BarColor.YELLOW,
            BarStyle.SOLID
    );


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.setPlayerListName(ChatColor.AQUA + player.getName());

        WELCOME_MESSAGE_BAR.addPlayer(player);

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        WELCOME_MESSAGE_BAR.removePlayer(player);
    }

}
