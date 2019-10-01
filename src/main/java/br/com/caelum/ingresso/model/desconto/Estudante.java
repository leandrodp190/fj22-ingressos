package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class Estudante implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.divide(new BigDecimal(2.0));
	}

}
