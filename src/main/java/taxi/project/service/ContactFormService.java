package taxi.project.service;

import java.util.List;

import taxi.project.model.ContactForm;

public interface ContactFormService {
	
	public ContactForm saveContactFormService(ContactForm contactForm);
	
	public List<ContactForm> readAllContactsService();
	
	public void deleteContactService(int id);

}
