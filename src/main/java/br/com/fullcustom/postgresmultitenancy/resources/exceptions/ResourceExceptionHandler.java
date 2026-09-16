package br.com.fullcustom.postgresmultitenancy.resources.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import br.com.fullcustom.postgresmultitenancy.services.exceptions.ObjectNotFoundException

ControllerAdvice
public class ResourceExceptionHandler 

	ExceptionHandlerObjectNotFoundException.class
	public ResponseEntityStandardError objectNotFoundObjectNotFoundException e, HttpServletRequest request 
		var status  HttpStatus.NOTFOUND
		var err  new StandardErrorSystem.currentTimeMillis, status.value, No encontrado, e.getMessage, request.getRequestURI
		return ResponseEntity.statusstatus.bodyerr