package util.validator.error;

public class SameError extends Error {

	public SameError() {
		super("Les champs ne sont pas identiques");
	}

}
