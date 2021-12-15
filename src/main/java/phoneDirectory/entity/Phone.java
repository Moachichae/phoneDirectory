package phoneDirectory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone {
    private String nameOrKey;
    private String birth;
    private String number;

    @Override
    public String toString() {
        return this.nameOrKey + "," + this.birth + "," + this.number + "\n";
    }
}
