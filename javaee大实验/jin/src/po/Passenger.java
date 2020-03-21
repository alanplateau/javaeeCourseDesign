package po;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
@Entity
@Table(name = "passenger", schema = "ars")
public class Passenger {
    private int passengerId;
    private String name;
    private String account;
    private String idCard;
    private String identifyType;

    @Id
    @Column(name = "passengerID")
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "IDCard")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "identifyType")
    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Passenger that = (Passenger) o;
        return passengerId == that.passengerId &&
                Objects.equals(name, that.name) &&
                Objects.equals(account, that.account) &&
                Objects.equals(idCard, that.idCard) &&
                Objects.equals(identifyType, that.identifyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, name, account, idCard, identifyType);
    }
}
