package edu.springlabs.websocket.protocol;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Message {

    @SerializedName("to")
    private List<String> to;

    @SerializedName("from")
    private String from;

    @SerializedName("text")
    private String text;

}
