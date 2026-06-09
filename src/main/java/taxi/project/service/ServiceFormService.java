package taxi.project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import taxi.project.model.ServiceForm;

public interface ServiceFormService {
	
	public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception;
	
	public List<ServiceForm> readAllService();
	
	public void deleteService(int id);

}
