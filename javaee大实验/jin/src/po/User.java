package po;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
@Entity
@Table(name = "user", schema = "ars")
public class User {
    private String account;
    private String password;
    private int type;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Id
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User that = (User) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }
}
