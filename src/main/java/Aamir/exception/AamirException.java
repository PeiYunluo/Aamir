package Aamir.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/7 17:00
 */
@Getter
@Setter
public class AamirException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String resultcode;
    /**
     * 错误信息
     */
    protected String message;

    public AamirException() {
        super();
    }

    public AamirException(String resultcode, String message) {
        super(resultcode);
        this.resultcode = resultcode;
        this.message = message;
    }

    public AamirException(String message, String resultcode, String message1) {
        super(message);
        this.resultcode = resultcode;
        this.message = message;
    }

    public AamirException(String message, Throwable cause, String resultcode, String message1) {
        super(message, cause);
        this.resultcode = resultcode;
        this.message = message1;
    }

    public AamirException(Throwable cause, String resultcode, String message) {
        super(cause);
        this.resultcode = resultcode;
        this.message = message;
    }

    public AamirException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String resultcode, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resultcode = resultcode;
        this.message = message1;
    }
}
