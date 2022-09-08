package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	@Test
	public void reajusteSer3PorCentQuandoDesempenhoADesejar(){
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Vitor Teste", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.realizarReajuste(funcionario , Desempenho.A_DESEJAR );
		
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteSer15PorCentQuandoDesempenhoBom(){
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Vitor Teste", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.realizarReajuste(funcionario , Desempenho.BOM );
		
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteSer20PorCentQuandoDesempenhoOtimo(){
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Vitor Teste", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.realizarReajuste(funcionario , Desempenho.OTIMO);
		
		
//		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
//		assertThrows(IllegalArgumentException.class, () -> {
//			assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
//		});
		assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
			}} );
	}

}
