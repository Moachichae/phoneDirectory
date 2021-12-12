package phoneDirectory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String password;


    @Override
    public String toString() {
        return this.id + "," + this.password + "\n";
    }
}
