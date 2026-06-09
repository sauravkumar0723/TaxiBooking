package taxi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taxi.project.dao.ContactFormCrud;
import taxi.project.model.ContactForm;

@Service
public class ContactFormServiceImpl implements ContactFormService {
	
	private ContactFormCrud contactFormCrud;
	
	
	@Autowired
	public void setContactFormCrud(ContactFormCrud contactFormCrud) {
		this.contactFormCrud = contactFormCrud;
	}
	
	public ContactForm saveContactFormService(ContactForm contactForm) {
		return contactFormCrud.save(contactForm); // return go to controller
	}

	@Override
	public List<ContactForm> readAllContactsService() {
		return contactFormCrud.findAll();
	}

	@Override
	public void deleteContactService(int id) {
		
		contactFormCrud.deleteById(id);
		
	}

	
	 

}
