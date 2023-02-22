package mx.edu.utez.airbnb.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomResponse<T> {
    T data;
    boolean error;
    int statusCode;
    String Message;
}
