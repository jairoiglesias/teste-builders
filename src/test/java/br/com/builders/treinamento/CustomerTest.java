package br.com.builders.treinamento;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	String idInsert = "553fa88c-4511-445c-b33a-ddff58d76998";
	String idUpdate = "553fa88c-4511-445c-b33a-ddff58d76886";
	
	@Before
    public void setup() throws Exception {
				
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/{customerId}", idInsert))
		.andExpect(status().isNoContent())
		.andDo(print());
	}
	
	@Test
	public void testShouldInsertCustomer() throws Exception{
		
		String crmId = "C645235";
		String baseUrl = "http://www.platformbuilders.com.br";
		String name = "Platform Builders Test";
		String login = "contato@platformbuilders.com.br";
		
		JSONObject jsonObj = new JSONObject();
				
		jsonObj.put("id", this.idInsert);
		jsonObj.put("crmId", crmId);
		jsonObj.put("baseUrl", baseUrl);
		jsonObj.put("name", name);
		jsonObj.put("login", login);
		
		mockMvc.perform(
        MockMvcRequestBuilders.post("/api/customers")
                .content(jsonObj.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print());
		
	}
	
	@Test
	public void testShouldGetCustomer() throws Exception{
		
		mockMvc.perform(
        MockMvcRequestBuilders.get("/api/customers/{customerId}", this.idUpdate))
        .andExpect(status().isOk())
        .andDo(print());
		
	}
	
	@Test 
	public void testShouldUpdateCustomer() throws Exception{
		
		String crmId = "C645235";
		String baseUrl = "http://www.platformbuilders.com.br";
		String name = "Plataform Builders é Topper!";
		String login = "contato@platformbuilders.com.br";
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("id", this.idUpdate);
		jsonObj.put("crmId", crmId);
		jsonObj.put("baseUrl", baseUrl);
		jsonObj.put("name", name);
		jsonObj.put("login", login);
		
		mockMvc.perform(MockMvcRequestBuilders.patch("/api/customers/{customerId}", this.idUpdate)
		 .content(jsonObj.toString())
         .contentType(MediaType.APPLICATION_JSON_UTF8)
         .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		 .andDo(print());
		
	}
	
	@Test
	public void testShouldDeleteCustomer() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/{customerId}", this.idInsert))
		 .andExpect(status().isNoContent())
		 .andDo(print());

	}
	
	@Test
	public void testShouldNotInsertCard() throws Exception{
		
		String id = "553fa88c-4511-445c-b33a-ddff58d76000";
		String crmId = "C645235";
		String baseUrl = "http://www.platformbuilders.com.br";
//		String name = "Platform Builders Test";
		String login = "contato@platformbuilders.com.br";
		
		JSONObject jsonObj = new JSONObject();
				
		jsonObj.put("id", id);
		jsonObj.put("crmId", crmId);
		jsonObj.put("baseUrl", baseUrl);
//		jsonObj.put("name", name);
		jsonObj.put("login", login);
		
		mockMvc.perform(
        MockMvcRequestBuilders.post("/api/customers")
                .content(jsonObj.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print());
		
	}
	
	@Test
	public void testShouldNotGetCustomerIdEmpty() throws Exception {
		
		mockMvc.perform(
	        MockMvcRequestBuilders.get("/api/customers/{customerId}", ""))
	        .andExpect(status().isMethodNotAllowed())
	        .andDo(print());
		
	}
	
	@Test
	public void testShouldNotUpdateCustomerCustomerIdEmpty() throws Exception{
		
		String crmId = "C645235";
		String baseUrl = "http://www.platformbuilders.com.br";
		String name = "Plataform Builders é Topper!";
		String login = "contato@platformbuilders.com.br";
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("id", this.idUpdate);
		jsonObj.put("crmId", crmId);
		jsonObj.put("baseUrl", baseUrl);
		jsonObj.put("name", name);
		jsonObj.put("login", login);
		
		mockMvc.perform(MockMvcRequestBuilders.patch("/api/customers/{customerId}", "")
		 .content(jsonObj.toString())
         .contentType(MediaType.APPLICATION_JSON_UTF8)
         .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isMethodNotAllowed())
		 .andDo(print());
		
		
	}
	
	@Test
	public void testShouldNotUpdateCustomerCustomerInvalidJSON() throws Exception{
		
		String crmId = "C645235";
		String baseUrl = "http://www.platformbuilders.com.br";
//		String name = "Plataform Builders é Topper!";
		String login = "contato@platformbuilders.com.br";
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("id", this.idUpdate);
		jsonObj.put("crmId", crmId);
		jsonObj.put("baseUrl", baseUrl);
//		jsonObj.put("name", name);
		jsonObj.put("login", login);
		
		mockMvc.perform(MockMvcRequestBuilders.patch("/api/customers/{customerId}", this.idUpdate)
		 .content(jsonObj.toString())
         .contentType(MediaType.APPLICATION_JSON_UTF8)
         .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isBadRequest())
		 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		 .andDo(print());
		
		
	}
	
	@Test
	public void testShouldNotDeleteCustomer() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/{customerId}", ""))
		 .andExpect(status().isMethodNotAllowed())
		 .andDo(print());
		
	}
	

}
