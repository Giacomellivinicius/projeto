package com.vinicius.mc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vinicius.mc.domain.Cliente;
import com.vinicius.mc.domain.enums.TipoCliente;
import com.vinicius.mc.dto.ClienteNewDTO;
import com.vinicius.mc.repositories.ClienteRepository;
import com.vinicius.mc.resources.exception.FieldMessage;
import com.vinicius.mc.services.validation.utils.BR;

	/* ConstraintValidator é a interface herdada
	 *  da biblioteca javax.validation.ConstraintValidator.
	 * Recebe os parâmetros <nome da anotação, e tipo da classe que aceita a anotação >
	 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	//Lógica de validação:
	
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
	
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
		}
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
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
