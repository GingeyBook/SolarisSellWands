package net.projectsolaris.sellwands;

import com.sun.jdi.CharType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;


public class giveHoe implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack goldenHoe = new ItemStack(Material.GOLDEN_HOE);
            ItemMeta meta = goldenHoe.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + "Sell Wand");
            meta.setLore(Collections.singletonList(ChatColor.WHITE + "Right click any chest to \n sell all avaliable items."));
            goldenHoe.setItemMeta(meta);
            player.getInventory().addItem(goldenHoe);
        }

        return true;
    }
}