package me.mchiappinam.pdghaedf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	List<Integer> itens = new ArrayList<Integer>();
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2iniciando...");
		File file = new File(getDataFolder(),"config.yml");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2verificando se a config existe...");
		if(!file.exists()) {
			try {
				getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2config inexistente, criando config...");
				saveResource("config_template.yml",false);
				File file2 = new File(getDataFolder(),"config_template.yml");
				file2.renameTo(new File(getDataFolder(),"config.yml"));
				getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2config criada");
			}catch(Exception e) {getServer().getConsoleSender().sendMessage("§c[PDGHAEDF] §cERRO AO CRIAR CONFIG");}
		}
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2registrando eventos...");
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2eventos registrados");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2definindo comandos...");
	    getServer().getPluginCommand("removerdurabilidade").setExecutor(new Comando(this));
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2comandos definidos");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2adicionando itens...");
		itens.addAll(getConfig().getIntegerList("itensToRemoveData"));
		for(int i : itens)
			getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2item "+i+" adicionado.");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2todos os itens foram adicionados.");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2ativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2Acesse: https://hostload.com.br/");
	}
	    
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2desativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHAEDF] §2Acesse: https://hostload.com.br/");
	}
}
