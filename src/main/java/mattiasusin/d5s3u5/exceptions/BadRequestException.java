package mattiasusin.d5s3u5.exceptions;

public class BadRequestException extends RuntimeException {
	public BadRequestException(String msg){
		super(msg);
	}
}
