package de.sglorch.sta.customabilities;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class STAListener implements Listener {

    @EventHandler
    public void onPlayerMove(@NotNull PlayerMoveEvent event) {
        Player player = event.getPlayer();

        /*
        Sirene
         */
        // Im Wasser
        if(player.hasPermission(CustomAbilities.PERM_SIRENE) && player.isInWater()) {
            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.WATER_BREATHING,
                            100,
                            1)
            );
            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.DOLPHINS_GRACE,
                            100,
                            1)
            );
        }
        // Nicht im Wasser
        else if(player.hasPermission(CustomAbilities.PERM_SIRENE) && !player.isInWater()) {
            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.SLOW,
                            100,
                            1)
            );
        }
        /*
        Wikinger
         */
        if(player.hasPermission(CustomAbilities.PERM_WIKINGER)
                && (
                        player.getLocation().getBlock().getBiome().equals(Biome.FROZEN_OCEAN)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.FROZEN_RIVER)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.SNOWY_TUNDRA)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.SNOWY_MOUNTAINS)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.SNOWY_BEACH)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.SNOWY_TAIGA)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.SNOWY_TAIGA_HILLS)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.SNOWY_TAIGA_MOUNTAINS)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.ICE_SPIKES)
                    ||  player.getLocation().getBlock().getBiome().equals(Biome.DEEP_FROZEN_OCEAN)
                )) {

            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.SPEED,
                            100,
                            1)
            );
        }
    }

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(player.hasPermission(CustomAbilities.PERM_WIKINGER)) {
            this.applyWikingerEffekte(player);
        }

        // TODO weitere permanente Effekte
    }
    private void applyWikingerEffekte(@NotNull Player player) {
        player.addPotionEffect(
                new PotionEffect(
                        PotionEffectType.DAMAGE_RESISTANCE,
                        Integer.MAX_VALUE,
                        1)
        );
        player.addPotionEffect(
                new PotionEffect(
                        PotionEffectType.HUNGER,
                        Integer.MAX_VALUE,
                        1)
        );
    }
    @EventHandler
    public void onPlayerConsume(@NotNull PlayerItemConsumeEvent event) {
        if(event.getItem().getType().equals(Material.MILK_BUCKET)) {
            Player player = event.getPlayer();

            if(player.hasPermission(CustomAbilities.PERM_WIKINGER)) {

                this.applyWikingerEffekte(player);
            }

            // TODO weitere permanente Effekte
        }
    }
}