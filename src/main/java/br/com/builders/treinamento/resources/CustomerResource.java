package br.com.builders.treinamento.resources;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.builders.treinamento.dto.request.CustomerRequest;
import br.com.builders.treinamento.repository.CustomerRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value = "API Sample")

public class CustomerResource {
	
	@Autowired
	CustomerRepository customerRepository;
	
	  																																							
	@RequestMapping(value = "/customers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerRequest request) throws Exception{
		  
		return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.insert(request));
		  																																															
	 }																																																																																																																																																																																																																																																							
	  
	  @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	  @ResponseStatus(value = HttpStatus.OK)
	  public ResponseEntity<Object> getCustomer(@PathVariable("customerId") String customerId) throws Exception{
		  
		  return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findOne(customerId));
		  
	  }
	  
	  @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	  @ResponseStatus(value = HttpStatus.OK)
	  public ResponseEntity<Object> getCustomerList() throws Exception{
		  
		  return ResponseEntity.status(HttpStatus.OK).body(customerRepository.findAll());
		  
	  }
	  
	  @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON)
	  @ResponseStatus(value = HttpStatus.OK)
	  public ResponseEntity<Object> createCustomer(@PathVariable("customerId") String customerId, @Valid @RequestBody CustomerRequest request) throws Exception{
		  
		  return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(request));
		  
	  }
	  
	  @RequestMapping(path = "/customers/{customerId}", method = RequestMethod.DELETE)
	  public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") String customerId) throws Exception {
		  
		  customerRepository.delete(customerId);
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	  }
	  

}
