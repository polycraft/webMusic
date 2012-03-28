package util.validator.error;

public class TooShortError extends Error {

	public TooShortError(int len) {
		super("Le champs doit contenir au moins "+len+" caractères");
	}

}
