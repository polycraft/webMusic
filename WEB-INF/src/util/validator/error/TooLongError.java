package util.validator.error;

public class TooLongError extends Error {

	public TooLongError(int len) {
		super("Le champs doit contenir au maximum "+len+" caractères");
	}

}
