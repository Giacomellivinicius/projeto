package com.vinicius.mc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.dto.ClienteDTO;
import com.vinicius.mc.repositories.ClienteRepository;
import com.vinicius.mc.resources.exception.FieldMessage;

	/* ConstraintValidator é a interface herdada
	 *  da biblioteca javax.validation.ConstraintValidator.
	 * Recebe os parâmetros <nome da anotação, e tipo da classe que aceita a anotação >
	 */
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	//Lógica de validação:
	
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
	
		Map <String, String> map = (Map <String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		
		List<FieldMessage> list = new ArrayList<>();

		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email","Email já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
