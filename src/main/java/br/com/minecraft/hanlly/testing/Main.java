package br.com.minecraft.hanlly.testing;

import br.com.minecraft.hanlly.testing.events.BasicEventHandler;
import br.com.minecraft.hanlly.testing.kits.ShovelHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(new BasicEventHandler(), this);
        this.getServer().getPluginManager().registerEvents(new ShovelHandler(), this);
        System.out.println("========================================");
        System.out.println("Super-Shovels plugin enabled!");
        System.out.println("========================================");



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
