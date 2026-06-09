package taxi.project.service;

import java.util.List;

import taxi.project.model.BookingForm;


public interface BookingFormService {

	public BookingForm saveBookingFormService(BookingForm bookingForm);
	
    public List<BookingForm> readAllBookingsService();
	
	public void deleteBookingService(int id);
	
}
