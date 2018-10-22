
package br.com.builders.treinamento.dto.response;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.builders.treinamento.exception.ErrorCodes;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@ApiModel(value = "Customer Request")
@Document
public class CustomerResponseDTO {

    @NotNull(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED)
    @Id
    @GeneratedValue
    private String id;
    
    private String crmId;
    
    private String baseUrl;
    
    private String name;
    
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
   

}
