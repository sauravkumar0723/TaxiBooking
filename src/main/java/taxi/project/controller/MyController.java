package taxi.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import taxi.project.model.BookingForm;
import taxi.project.model.ContactForm;
import taxi.project.model.ServiceForm;
import taxi.project.service.BookingFormService;
import taxi.project.service.ContactFormService;
import taxi.project.service.ContactFormServiceImpl;
import taxi.project.service.ServiceFormService;

@Controller
public class MyController {
	
	// we use this ContactFormServiceImpl() so i will do Autowiring
	
	private ContactFormService contactFormService;
	
	// 
	private BookingFormService bookingFormService;
	private ServiceFormService serviceFormService;
	
	
	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}

	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path = {"/","home","welcome","index"})
	public String welcomeView(HttpServletRequest request, Model m) {
		String requestURI = request.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		// ioc container internally create the object of BookingForm
		m.addAttribute("bookingForm", new BookingForm());
		return "index";
	}
	
	@GetMapping("about")
	public String aboutView(HttpServletRequest request, Model m) {
		String requestURI = request.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		return "about";
	}
	
	@GetMapping("cars")
	public String carsView(HttpServletRequest request, Model m) {
		String requestURI = request.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		return "cars";
	}
	
	@GetMapping("services")
	public String servicesView(HttpServletRequest request, Model m) {
		String requestURI = request.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		
		// Rendering :- we collect the data before opening the service page;
		// Data Collection
		List<ServiceForm> allService = serviceFormService.readAllService();
		m.addAttribute("allservices", allService);
		
		
		return "services";
	}
	
	@GetMapping("contacts")
	public String contactsView(HttpServletRequest request, Model m) 
	{
		String requestURI = request.getRequestURI();
		m.addAttribute("mycurrentpage", requestURI);
		m.addAttribute("contactForm", new ContactForm());
		return "contacts";
	}
	
	//Contact Form
	@PostMapping("contactform")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm, 
		BindingResult bindingResult	,Model m, RedirectAttributes redirectAttributes) 
	{
		// Error gives in object form therefore i am using BindingResult
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult); // we put bindingResult in model
			return "contacts";
		}
//		we call for this fields private ContactFormService contactFormService;
		ContactForm saveContactFormService = contactFormService.saveContactFormService(contactForm);  // 
		if(saveContactFormService!=null) {
			redirectAttributes.addFlashAttribute("message", "Message sent sucessfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "Something Went Wrong");
		}
		
		
		System.out.println(contactForm);
		return "redirect:/contacts";
	}
	
	// post mapping for booking mapping
	@PostMapping("bookingform")
	public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm,
			BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes) 
	{
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult); // if error will come then i goto bindingResult.
			return "index";
		} else if(bookingForm.getAdult()+bookingForm.getChildren()>4) {
			m.addAttribute("message", "The total no of adult and children cannot exceed 4"); // if error will come then i goto bindingResult.
			return "index";
		}
		//DAO 
		
//		System.out.println(bookingForm);
		//we send data to service
		BookingForm saveBookingFormService = bookingFormService.saveBookingFormService(bookingForm);
		// we check booking form is not null or not 
		if(saveBookingFormService!=null) {
			redirectAttributes.addFlashAttribute("message", "Booking sucessfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "Something Went Wrong");
		}
		return "redirect:/index";
	}
	
	// admin login
	@GetMapping("/login")
	public String adminLoginview(HttpServletRequest request, Model model) {
		
		ServletContext servletContext = request.getServletContext();
		Object attribute = servletContext.getAttribute("logout");
		if(attribute instanceof Boolean) {
			model.addAttribute("logout", attribute);
			servletContext.removeAttribute("logout");
		}
		
		return "adminlogin";
	}
	
	
}
