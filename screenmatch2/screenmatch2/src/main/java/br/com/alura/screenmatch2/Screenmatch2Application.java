package br.com.alura.screenmatch2;

import br.com.alura.screenmatch2.model.DadosSeries;
import br.com.alura.screenmatch2.service.ConsumoAPI;
import br.com.alura.screenmatch2.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Screenmatch2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Screenmatch2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=9549dd8a");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();

		DadosSeries dadosSerie = conversor.obterDados(json, DadosSeries.class);
		System.out.println(dadosSerie);
	}
}
