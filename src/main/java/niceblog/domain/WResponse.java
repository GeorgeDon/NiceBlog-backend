package niceblog.domain;

import java.util.Map;

/**
 * Created by GeorgeDon on 2017/4/10.
 */
public class WResponse {
    private String message;
    private Map<String, Object> data;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WResponse{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                '}';
    }
}
