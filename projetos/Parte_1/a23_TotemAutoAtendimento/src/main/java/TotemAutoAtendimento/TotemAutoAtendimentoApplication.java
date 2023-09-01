package TotemAutoAtendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TotemAutoAtendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TotemAutoAtendimentoApplication.class, args);

		//Chamada do console de interação do usuário

		TotemAutoAtendimentoConsole console = new TotemAutoAtendimentoConsole();
		console.iniciarConsole();

	}

}
