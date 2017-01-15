package edu.springlabs.websocket.protocol;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Payload {

    @SerializedName("command")
    private String command;

    @SerializedName("data")
    private Object data;

}
