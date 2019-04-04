package br.unisul.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Disciplina;
import br.unisul.web.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaRepository rep;
	
	public Disciplina find (Integer id) {
		Optional<Disciplina> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public Disciplina insert (Disciplina obj) {
		return rep.save(obj);
	}
	
	public Disciplina update (Disciplina obj) {
		find(obj.getId());
		return rep.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	public List<Disciplina> findAll(){
		return rep.findAll();
	}
}
