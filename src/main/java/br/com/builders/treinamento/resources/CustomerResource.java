package br.com.builders.treinamento.resources;

import java.util.ArrayList;
import java.util.List;

import javax.naming.ServiceUnavailableException;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.builders.treinamento.dto.request.CustomerRequest;
import br.com.builders.treinamento.dto.response.SampleResponse;
import br.com.builders.treinamento.repository.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "API Sample")

public class CustomerResource {
	
	@Autowired
	CustomerRepository customerRepository;
	
	 @ApiOperation(value = "Listar Samples", httpMethod = "GET", response = CustomerResource.class)
	  @ApiResponses(value = {@ApiResponse(code = 200, message = "Lista de Sample"),
	      @ApiResponse(code = 500, message = "Erro interno do sistema"),
	      @ApiResponse(code = 503, message = "Erro ao acessar um servico/servidor"),
	      @ApiResponse(code = 400, message = "Erro nos parametros no request"),
	      @ApiResponse(code = 422, message = "Erro de negocio")})
	  @RequestMapping(value = "/samples", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	  @ResponseStatus(value = HttpStatus.OK)
	  public List<SampleResponse> listarCustomers(
	      @ApiParam(name = "apikey", required = true, value = "apikey") @RequestHeader(required = true) final String apikey)
	      throws ServiceUnavailableException {
	    
	    List<SampleResponse> response = new ArrayList<>();
//	    response.add(SampleResponse.builder().id("sample-id").build());

	    return response;
	  }
	  																																							
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
	  
	  @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
	  @ResponseStatus(value = HttpStatus.OK)
	  public ResponseEntity<Object> createCustomer(@PathVariable("customerId") String customerId, @Valid @RequestBody CustomerRequest request) throws Exception{
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.save(request));
		  
	  }
	  
	  @RequestMapping(path = "/customers/{customerId}", method = RequestMethod.DELETE)
	  public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") String customerId) throws Exception {
		  
		  customerRepository.delete(customerId);
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	  }
	  
	  @RequestMapping(value = "/testev2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	  @ResponseStatus(value = HttpStatus.OK)
	  public String teste() {
		  return "teste";
	  }

}
