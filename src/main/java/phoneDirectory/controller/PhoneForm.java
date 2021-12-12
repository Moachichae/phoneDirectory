package phoneDirectory.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PhoneForm {
    private String nameOrKey;
    private String birth;
    private String number;
    private String token;

}
