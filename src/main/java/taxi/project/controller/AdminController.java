package taxi.project.controller;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import taxi.project.model.BookingForm;
import taxi.project.model.ContactForm;
import taxi.project.model.ServiceForm;
import taxi.project.service.BookingFormService;
import taxi.project.service.ContactFormService;
import taxi.project.service.ServiceFormService;
import taxi.project.sspringecurity.config.AdminCredentialsService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	private ContactFormService contactFormService;
	private AdminCredentialsService adminCredentialsService;
	
	private BookingFormService bookingFormService;
	
	private ServiceFormService serviceFormService;
	
	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}
	
	@Autowired
	public void setAdminCredentialsService(AdminCredentialsService adminCredentialsService) {
		this.adminCredentialsService = adminCredentialsService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}
	
	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@GetMapping("/dashboard")
	public String adminDashboard() {
		
		return "admin/dashboard";
	}
	
	@GetMapping("readAllContacts")
	public String readAllContacts(Model model) {
		model.addAttribute("allContacts", contactFormService.readAllContactsService());
		return "admin/readAllContacts";
	}
	
	@GetMapping("deleteContact/{id}")
	public String deleteContact( @PathVariable int id, RedirectAttributes redirectAttributes) {
		contactFormService.deleteContactService(id);
		redirectAttributes.addFlashAttribute("message", "Contact deleted successfully");
		return "redirect:/admin/readAllContacts";
	}
	
	
	@GetMapping("changeCredentials")
	public String changeCredentialsView( ) {
		
		return "admin/changeCredentials";
	}
	
	@PostMapping("changeCredentials")
	public String changeCredentials( 
			@RequestParam("oldusername") String oldusername,
			@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newusername") String newusername,
			@RequestParam("newpassword") String newpassword,
			RedirectAttributes redirectAttributes
			) {
		
		String result = adminCredentialsService.checkAdminCredentials(oldusername, oldpassword);
		System.out.println(result);
		if(result.equals("SUCCESS")) {
			// password update 
			 result  = adminCredentialsService.updateAdminCredentials(newusername, newpassword, oldusername);
			 redirectAttributes.addFlashAttribute("message", result);
		} else {
			 redirectAttributes.addFlashAttribute("message", result);
		}
		
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("readAllBookings")
	public String readAllBookings(Model model) {
		
		List<BookingForm> allBookingsService = bookingFormService.readAllBookingsService();
		System.out.println(allBookingsService);
		
		model.addAttribute("allBookings", allBookingsService);
		return "admin/readallbookings";
	}
	
	@GetMapping("deleteBooking/{id}")
	public String deleteBooking( @PathVariable int id, RedirectAttributes redirectAttributes) {
		bookingFormService.deleteBookingService(id);
		redirectAttributes.addFlashAttribute("message", "Booking Deleted Sucessfully");
		return "redirect:/admin/readAllBookings";	
	}
	
	// SERVICES
	@GetMapping("addService")
	public String addServiceView( ) {
		
		return "admin/addservice";	
	}
	
	// we use this to stopbinding the image. b/c image is not  a string
	@InitBinder
	public void stopBinding(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("image");
	}
	
	@PostMapping("addService")
	public String addService( @ModelAttribute ServiceForm serviceForm ,
			@RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
		
	 
	 String originalFilename = multipartFile.getOriginalFilename();
	 serviceForm.setImage(originalFilename);
		try {
			 // we call the serviceFormService to add Service
			 ServiceForm service = serviceFormService.addService(serviceForm, multipartFile);
			 if(service!=null) {
				 redirectAttributes.addFlashAttribute("msg", "Service Added Successfully");
			 } else {
				 redirectAttributes.addFlashAttribute("msg", "Something went wrong");
			 }
		} catch (Exception e) {
			 redirectAttributes.addFlashAttribute("msg", "Something went wrong");
		}
		
		return "redirect:/admin/addService";	
	}
	
	//
	@GetMapping("deleteServices")
	public String deleteServices(Model model) {

	    List<ServiceForm> allServices = serviceFormService.readAllService();
	    model.addAttribute("allservices", allServices);

	    return "admin/deleteservices";
	}
	
	@PostMapping("deleteService/{id}")
	public String deleteService(@PathVariable int id,
	                            RedirectAttributes redirectAttributes) {

	    serviceFormService.deleteService(id);

	    redirectAttributes.addFlashAttribute("message", "Service Deleted Successfully");

	    return "redirect:/admin/deleteServices";
	}
	
}
