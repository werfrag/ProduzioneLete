package me.werfrag;

import me.werfrag.events.WaterFillListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Produzione lette attivato");

        getServer().getPluginManager().registerEvents(new WaterFillListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Produzione Lette disattivato");
    }
}
