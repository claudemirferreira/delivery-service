package br.com.setebit.deliveryservice;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.setebit.deliveryservice.domain.Caixa;
import br.com.setebit.deliveryservice.domain.Entrega;
import br.com.setebit.deliveryservice.domain.Entregador;
import br.com.setebit.deliveryservice.enums.StatusCaixaEnum;
import br.com.setebit.deliveryservice.enums.StatusEntregaEnum;
import br.com.setebit.deliveryservice.repository.CaixaRepository;
import br.com.setebit.deliveryservice.repository.EntregaRepository;
import br.com.setebit.deliveryservice.repository.EntregadorRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(EntregaRepository entregaRepository, EntregadorRepository entregadorRepository,
			CaixaRepository caixaRepository) {
		return args -> {
			initDados(entregaRepository, entregadorRepository, caixaRepository);
		};
	}

	private void initDados(EntregaRepository entregaRepository, EntregadorRepository entregadorRepository,
			CaixaRepository caixaRepository) {
//		Entregador entregador = entregadorRepository.save(Entregador.builder().nome("joão").build());
//		entregadorRepository.save(Entregador.builder().nome("maria").build());
//		Caixa caixa  = Caixa.builder().data(OffsetDateTime.now()).status(StatusCaixaEnum.ABERTO.getCodigo()).build();
//
//		caixa = caixaRepository.save(caixa);
//
//		for (int i = 1; i < 11; i++) {
//			entregaRepository.save(
//					Entrega.builder()
//					.caixa(caixa)
//					.data(OffsetDateTime.now())
//					.status(StatusEntregaEnum.ENTREGUE.getCodigo())
//					.valorEntregador(new BigDecimal(10))
//					.entregador(entregador)
//					.build());
//		}

	}

}