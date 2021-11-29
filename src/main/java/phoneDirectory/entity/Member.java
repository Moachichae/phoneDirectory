package phoneDirectory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
    private String id;
    private String password;

    @Override
    public String toString() {
        return this.id + "," + this.password + "\n";
    }
}
