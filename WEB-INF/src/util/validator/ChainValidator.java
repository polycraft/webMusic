package util.validator;

import java.util.ArrayList;
import java.util.List;

import util.validator.error.Error;

public class ChainValidator<T> extends Validator<T>{
	private List<Validator<T>> validators;
	private List<Error> errors;
	
	
	public ChainValidator() {
		super();
		this.validators = new ArrayList<Validator<T>>();
	}

	/*
	 * Test tous les validateurs avec la valeur value
	 */
	protected boolean valid() {
		boolean isValid=true;
		for(Validator<T> validator:validators)
		{
			//On vérifie si il y a une erreur
			if(!validator.validate(value)) {
				errors.add(validator.getError());
				isValid=false;
			}
		}			
		return isValid;
	}
	
	/*
	 * initialisation de la liste.
	 * Effectué ici pour autoriser les appels multiples de validate
	 */
	public void clearError() {
		this.errors = new ArrayList<Error>();
	}
	
	/*
	 * Retourne la présence d'erreur
	 */
	public boolean hasError() {
		if(errors==null)
			return false;
		return errors.size()!=0;
	}
	
	/*
	 * Retourne les erreurs
	 */
	public List<Error> getErrors() {
		return errors;
	}
	
	/*
	 * Retourne la première erreurs
	 */
	public Error getError() {
		if(hasError())
			return errors.get(0);
		return null;
	}
	
	/*
	 *  Ajoute un validateur
	 */
	public ChainValidator<T> add(Validator<T> validator) {
		validators.add(validator);
		return this;		
	}
	
	public ChainValidator<T> set(T value) {
		this.setValue(value);
		return this;		
	}
	
}
