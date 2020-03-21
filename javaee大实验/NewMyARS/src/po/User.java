package po;

import java.util.Objects;

/**
 * @Author 王怡静
 * @Date 2019-12-07 18:48
 * @Version 1.0
 */
public class User {
    private String account;
    private String password;
    private Integer type;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
