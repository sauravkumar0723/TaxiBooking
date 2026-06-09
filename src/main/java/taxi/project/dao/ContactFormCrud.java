package taxi.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taxi.project.model.ContactForm;

@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer> {
	
	@Override
	public <S extends ContactForm> S save(S entity); //ContactForm--> here return ContactForm in  contactForm Serrvice imple
	
	@Override
	public List<ContactForm> findAll();
	
	@Override
	public void deleteById(Integer id);
}
