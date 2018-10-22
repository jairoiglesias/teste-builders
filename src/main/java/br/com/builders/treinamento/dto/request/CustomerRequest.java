
package br.com.builders.treinamento.dto.request;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.builders.treinamento.exception.ErrorCodes;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "Customer Request")

@Document(collection = "jairo_iglesias_CUSTOMERS")
public class CustomerRequest{
	
	@NotNull(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED)
	private String id;
    
    @NotNull(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED)
    private String crmId;
    
    @NotNull(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED)
    private String baseUrl;
    
    @NotNull(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED)
    private String name;
    
    @NotNull(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED)
    private String login;
    
	public String getCrmId() {
		return crmId;
	}

	public void setCrmId(String crmId) {
		this.crmId = crmId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
