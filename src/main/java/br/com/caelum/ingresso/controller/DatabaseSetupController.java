//package br.com.caelum.ingresso.controller;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import br.com.caelum.ingresso.dao.FilmeDao;
//import br.com.caelum.ingresso.dao.SalaDao;
//import br.com.caelum.ingresso.model.Filme;
//import br.com.caelum.ingresso.model.Sala;
//
//@Controller
//@RequestMapping("/setup")
//public class DatabaseSetupController {
//
//	@Autowired
//	private FilmeDao filmeDao;
//
//	@Autowired
//	private SalaDao salaDao;
//
//	@GetMapping("/filmes")
//	@Transactional
//	public String setupFilmes() {
//		if (filmeDao.findAll().size() == 0) {
//			List.of(
//				new Filme("Blade Runner", Duration.ofMinutes(150), "Sci-fi"),
//				new Filme("Mulan", Duration.ofMinutes(90), "Animação"),
//				new Filme("Kill Bill", Duration.ofMinutes(120), "Ação"),
//				new Filme("Inception", Duration.ofMinutes(130), "Sci-fi"),
//				new Filme("Toy Story 2", Duration.ofMinutes(130), "Animação"),
//				new Filme("Titanic", Duration.ofMinutes(180), "Drama"),
//				new Filme("It", Duration.ofMinutes(130), "Terror"),
//				new Filme("Aliens", Duration.ofMinutes(130), "Sci-fi"),
//				new Filme("Contact", Duration.ofMinutes(120), "Sci-fi")
//			).stream()
//			.forEach(filmeDao::save);
//		}
//
//		return "redirect:/";
//	}
//
//	@GetMapping("/salas")
//	@Transactional
//	public String setupSalas() {
//		if (salaDao.findAll().size() == 0) {
//			List.of(
//				new Sala("Sala 1"),
//				new Sala("Sala 2"),
//				new Sala("Sala 3"),
//				new Sala("Sala 3D"),
//				new Sala("Sala 5D")
//			).stream()
//			.forEach(salaDao::save);
//		}
//		return "redirect:/";
//	}
//}