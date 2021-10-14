package gomes.filipe.service;

import java.time.LocalDate;
import java.time.Period;

import gomes.filipe.entity.Vendedor;
import gomes.filipe.exception.ServiceException;

public class DataNascimentoValidator implements Validator<Vendedor> {

	public boolean maiorDeIdade(Vendedor vendedor) {
		int idade = Period.between(vendedor.getDataNascimento(), LocalDate.now()).getYears();
		return idade >= 18;
	}
	
	@Override
	public void valida(Vendedor vendedor) {
		if (!maiorDeIdade(vendedor))
			throw new ServiceException("A idade do vendedor tem que ser maior ou igual à 18 anos");
		
	}

}
