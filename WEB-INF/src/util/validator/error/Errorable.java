package util.validator.error;

public interface Errorable {
	public boolean hasError();
	public Error getError() throws Exception;
	public void clearError();
}
