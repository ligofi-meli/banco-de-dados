package gomes.filipe.service;

import gomes.filipe.entity.Vendedor;
import gomes.filipe.exception.ServiceException;

public class CpfValidator implements Validator<Vendedor> {

	@Override
	public void valida(Vendedor vendedor) {
		if (vendedor.getCpf() == null || vendedor.getCpf().isEmpty())
			throw new ServiceException("É obrigatório preencher o campo cpf");
		
	}

}
