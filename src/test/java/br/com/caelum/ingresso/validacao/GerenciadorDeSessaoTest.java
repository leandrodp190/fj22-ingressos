package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {

	private Filme roqueOne;
	private Sala sala3d;
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreza;
	private Sessao sessaoDasDezoito;
	
	@Before
	public void preparaSessoes() {
		this.roqueOne = new Filme("Roque One", Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		this.sala3d = new Sala("Sala 3D", BigDecimal.TEN);
		
		this.sessaoDasDez = new Sessao(LocalTime.parse("10:00:00"), sala3d , roqueOne);
		this.sessaoDasTreza = new Sessao(LocalTime.parse("13:00:00"), sala3d , roqueOne);
		this.sessaoDasDezoito = new Sessao(LocalTime.parse("18:00:00"), sala3d , roqueOne);
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.cabe(sessaoDasDez));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessaoTerminandoDentroDoHoraioDeUmaSessaoJaExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		Sessao sessao = new Sessao(sessaoDasDez.getHorario().minusHours(1), sala3d, roqueOne);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertFalse(gerenciador.cabe(sessao));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessaoIniciandoDentroDoHoraioDeUmaSessaoJaExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Sessao sessao = new Sessao(sessaoDasDez.getHorario().plusHours(1), sala3d, roqueOne);
		Assert.assertFalse(gerenciador.cabe(sessao));
	}
	
	@Test
	public void garanteQueDevePermitirUmaInsercaoEntreDoisFilmes() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez, sessaoDasDezoito);
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Assert.assertTrue(gerenciador.cabe(sessaoDasTreza));
	}
	
	@Test
	public void garanteQueNaoDevePermitirUmaSessaoQueTerminaNoProximoDia() {
		List<Sessao> sessoes = Collections.EMPTY_LIST;
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		Sessao sessaoQueTerminaAmanha = new Sessao(LocalTime.parse("23:00:00"), sala3d, roqueOne);
		Assert.assertFalse(gerenciador.cabe(sessaoQueTerminaAmanha));
	}

}
