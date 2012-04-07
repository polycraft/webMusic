package util.validator;

public class LengthValidator extends SimpleValidator<String> {
	private LengthMinValidator min;
	private LengthMaxValidator max;

	public LengthValidator(int min, int max) {
		super();
		if (min > max)
			throw new IllegalArgumentException("min must be inferior to max");
		this.min = new LengthMinValidator(min);
		this.max = new LengthMaxValidator(max);
	}

	public boolean valid() {
		if (!min.validate(this.value)) {
			error = min.getError();
			return false;
		} else if (!max.validate(this.value)) {
			error = max.getError();
			return false;
		}
		return true;
	}
}
