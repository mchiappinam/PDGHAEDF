package me.mchiappinam.pdghaedf;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Comando implements CommandExecutor {

	private Main plugin;
	public Comando(Main main) {
		plugin=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("removerdurabilidade")) {
			if(((Player)sender).getItemInHand().getType()==Material.AIR) {
				sender.sendMessage("§3[AEDF] §cVocê não tem nenhum item na sua mão.");
				return true;
			}
			if(!plugin.itens.contains(((Player)sender).getItemInHand().getTypeId())) {
				sender.sendMessage("§3[AEDF] §cEste item não pode ter a durabilidade removida.");
				sender.sendMessage("§3[AEDF] §cEste comando é usado em, por exemplo, elmo de NanoSuit, possibilitando craftar para QuantumSuit");
				return true;
			}
			ItemStack is = new ItemStack(Material.getMaterial(((Player)sender).getItemInHand().getTypeId()), ((Player)sender).getItemInHand().getAmount(), (byte)0);
			((Player)sender).setItemInHand(is);
			return true;
		}
		return false;
	}
}
