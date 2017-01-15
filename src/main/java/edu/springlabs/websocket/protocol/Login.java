package edu.springlabs.websocket.protocol;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Login {

    @SerializedName("nickname")
    private String nickname;

}
