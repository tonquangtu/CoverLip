package com.clteam.model;

import java.util.List;

/**
 * Created by Dell on 21-May-17.
 */
public class ClientData<E> {

    public static int SUCCESS = 1;

    public static int ERROR = 0;

    public static String NO_DATA = "no_data";

    public static String HAVE_DATA = "have_data";

    private String message;

    private int success;

    private List<E> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }
}
