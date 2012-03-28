package util.validator.error;

public class BlankError extends Error {

	public BlankError() {
		super("Le champs doit être remplit");
	}

}
