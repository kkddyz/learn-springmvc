package cn.itcast.domain;


/**
 * @author kkddyz
 */
public class Account {
    private int money;

    private User owner;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", owner=" + owner +
                '}';
    }
}
