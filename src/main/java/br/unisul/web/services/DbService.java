package br.unisul.web.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Aluno;
import br.unisul.web.domain.Disciplina;

import br.unisul.web.repositories.AlunoRepository;
import br.unisul.web.repositories.DisciplinaRepository;

@Service
public class DbService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public void initializeDatabase() throws ParseException {
		Aluno aluno = new Aluno("Lucas");
		Aluno aluno1 = new Aluno("João");
		Aluno aluno2 = new Aluno("Maria");

		Disciplina disciplina = new Disciplina("Matemática");
		Disciplina disciplina1 = new Disciplina("Língua Portuguesa");
		Disciplina disciplina2 = new Disciplina("Geografia");
		
		aluno.getDisciplinas().addAll(Arrays.asList(disciplina, disciplina2));
		aluno1.getDisciplinas().addAll(Arrays.asList(disciplina2, disciplina1));
		aluno2.getDisciplinas().addAll(Arrays.asList(disciplina1, disciplina));
		
		aluno.getEmails().addAll(Arrays.asList("email1@email.com", "email2@email.com"));
		aluno1.getEmails().addAll(Arrays.asList("email2@email.com", "email3@email.com"));
		
		disciplinaRepository.saveAll(Arrays.asList(disciplina, disciplina1, disciplina2));
		alunoRepository.saveAll(Arrays.asList(aluno, aluno1, aluno2));
	}

}