package phoneDirectory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Phone {
    private String nameOrKey;
    private String birth;
    private String number;

    public Phone(){}

    public Phone(String nameOrKey, String birth, String number){
        this.nameOrKey = nameOrKey;
        this.birth = birth;
        this.number = number;
    }


    public String getNameOrKey() {
        return nameOrKey;
    }

    public void setNameOrKey(String nameOrKey) {
        this.nameOrKey = nameOrKey;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.nameOrKey + "," + this.birth + "," + this.number + "\n";
    }
}
