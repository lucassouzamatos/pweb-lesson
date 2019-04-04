package br.unisul.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Aluno;
import br.unisul.web.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository rep;
	
	public Aluno find (Integer id) {
		Optional<Aluno> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Aluno insert (Aluno obj) {
		return rep.save(obj);
	}
	
	public Aluno update (Aluno obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	public List<Aluno> findAll(){
		return rep.findAll();
	}
}
