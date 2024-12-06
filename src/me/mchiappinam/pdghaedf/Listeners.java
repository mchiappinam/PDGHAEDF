package me.mchiappinam.pdghaedf;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class Listeners implements Listener {

	private Main plugin;
	public Listeners(Main main) {
		plugin=main;
	}
	
	@EventHandler//(priority=EventPriority.MONITOR)
	public void onSlotChange(PlayerItemHeldEvent e) {
		if(e.getPlayer().getInventory().getItem(e.getNewSlot())!=null)
			if(plugin.itens.contains(e.getPlayer().getInventory().getItem(e.getNewSlot()).getTypeId())) {
				e.getPlayer().sendMessage("§3[AEDF] §a§lO item que está em sua mão só consegue ser craftado após digitar o comando §2§l/removerdurabilidade");
				e.getPlayer().sendMessage("§3[AEDF] §fOBS: O comando é gratuito e remove a durabilidade do seu item, fazendo-o \"desbugar\" e possibilitando o craft.");
			}
	}
}
