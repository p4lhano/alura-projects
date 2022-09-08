package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	private BonusService service;
	private BigDecimal bonus;

	@BeforeEach
	public void starter(){
		service = new BonusService();
		bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		assertEquals(new BigDecimal("0.00"), bonus);
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
	@Test
	void thows() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

//		assertEquals(new BigDecimal("1000.00"), bonus);
//		assertThrows(Exception.class,() -> assertEquals(new BigDecimal("1000.00"), bonus) );
		assertThrows(Exception.class,new Executable(){

			@Override
			public void execute() throws Throwable {
				assertEquals(new BigDecimal("1000.00"), bonus);
				
			}
			
		} );
		
	}

}
