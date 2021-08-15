package de.sglorch.sta.customabilities;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class CustomAbilities extends JavaPlugin {

    public static final String PERM_WIKINGER = "sta.abilities.wikinger";
    public static final String PERM_SIRENE = "sta.abilities.sirene";

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new STAListener(), this);
        this.getServer().getPluginManager().addPermission(new Permission(CustomAbilities.PERM_WIKINGER, PermissionDefault.FALSE));
        this.getServer().getPluginManager().addPermission(new Permission(CustomAbilities.PERM_SIRENE, PermissionDefault.FALSE));
        this.getServer().getLogger().log(Level.INFO, "[CustomAbilities] STA Abilities enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getServer().getLogger().log(Level.INFO, "[CustomAbilities] STA Abilities disabled!");
    }
}