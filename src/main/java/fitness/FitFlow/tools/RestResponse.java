package fitness.FitFlow.tools;

import fitness.FitFlow.model.User;
import org.springframework.stereotype.Component;

@Component
public class RestResponse {

    private Object object;
    private int statusCode;
    private String statusMessage;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
