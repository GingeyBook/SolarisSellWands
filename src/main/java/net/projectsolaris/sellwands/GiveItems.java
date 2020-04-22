package net.projectsolaris.sellwands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.*;

public class GiveItems extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabling SolarisSellWands by GingeyBook...");

    }

    @Override
    public void onDisable() {
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("si")) {
            if (args.length >= 3) {
                Player p = Bukkit.getPlayer(args[1]);
                String type = args[2];
                String give = args[0];
                try {
                    if (give.equalsIgnoreCase("give")) {
                        if (p != null) {
                            if (type.equalsIgnoreCase("sellwand")) {
                                int uses = Integer.parseInt(args[3]);
                                ItemStack itemStack = new ItemStack(Material.GOLDEN_HOE);
                                ItemMeta itemMeta = itemStack.getItemMeta();

                                itemMeta.setDisplayName(ChatColor.YELLOW + "Sell Wand");
                                itemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Right click on any chest to sell all items inside. " + uses));

                                itemStack.setItemMeta(itemMeta);
                                p.getInventory().addItem(itemStack);

                            } else if (type.equalsIgnoreCase("sellcharm")) {
                                ItemStack itemStack = new ItemStack(Material.ENDER_PEARL);
                                ItemMeta itemMeta = itemStack.getItemMeta();

                                itemMeta.setDisplayName(ChatColor.YELLOW + "Sell Charm");
                                itemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Place this item in any chest to sell all items inside."));

                                itemStack.setItemMeta(itemMeta);
                                p.getInventory().addItem(itemStack);
                            }
                        }
                }
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + args[2] + "is not parsable.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Incorrect usage: /si give <player> <type> {uses}");
            }
        }
        return false;
    }



}