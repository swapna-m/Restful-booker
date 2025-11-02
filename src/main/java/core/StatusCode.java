package core;

public enum StatusCode {
    SUCCESS(200,"Request is Successful"),
    NO_CONTENT(204,"No response to send"),
    CREATED(201,"Request Creation is Successful"),
    NOT_FOUND(404,"Page or Resource is Not Found");


    public final int code;
    public final String msg;

    StatusCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
