package dev.palhano.forum.alura.config.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * É um Interceptador (Filter) para erros lançados na validação de criação de objetos 
 * 
 * */
@RestControllerAdvice
public class ErrorValidationHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class) //ExceptionHandler- diz que vai ler alguma exessão lançada, e o arqumento que recebe é a classe de excessão a ser capturada
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ErrorValidationDTO> handle(MethodArgumentNotValidException e) {
		List<ErrorValidationDTO> errorValidations = new ArrayList<>();
		
		e.getBindingResult().getFieldErrors().stream().forEach(error -> {
			String mensagemError = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			errorValidations.add(new ErrorValidationDTO(error.getField(), mensagemError));
		});
		
		
		return errorValidations;
	}
	
	@ExceptionHandler(NotFoundException.class) //ExceptionHandler- diz que vai ler alguma exessão lançada, e o arqumento que recebe é a classe de excessão a ser capturada
	public ResponseEntity<?> notFoundException(NotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
}
