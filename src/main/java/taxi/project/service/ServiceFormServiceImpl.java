package taxi.project.service;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import taxi.project.dao.ServiceFormCrud;
import taxi.project.model.ServiceForm;

@Service
public class ServiceFormServiceImpl implements ServiceFormService {
	
	private ServiceFormCrud serviceFormCrud;
	
	@Autowired
	public void setServiceFormCrud(ServiceFormCrud serviceFormCrud) {
		this.serviceFormCrud = serviceFormCrud;
	}


	@Override
	@Transactional(rollbackOn = Exception.class)
	public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception {
		
		ServiceForm save = null;
		try {
			save = serviceFormCrud.save(serviceForm);
			if (save != null) {

				String path = "D:\\spring_learning\\TaxiBooking\\src\\main\\resources\\static\\myserviceimg\\"
						+ multipartFile.getOriginalFilename();
				byte[] bytes = multipartFile.getBytes();

				FileOutputStream fos = new FileOutputStream(path);
				fos.write(bytes);
			}
		} catch (Exception e) {
			save=null;
			throw e;
		}
		return save;
	}


	@Override
	public List<ServiceForm> readAllService() {
		
		return serviceFormCrud.findAll();
	}


	@Override
	public void deleteService(int id) {
		// TODO Auto-generated method stub
		serviceFormCrud.deleteById(id);
	}


	
	

}
