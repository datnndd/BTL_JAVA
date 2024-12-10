package model.entity;

import java.io.Serializable;
import java.util.Objects;

public class MembershipPlan implements Serializable {
    private int idPlan;
    private int namePlan;
    private double price;
    private int duration;

    public MembershipPlan(int idPlan, int namePlan, double price, int duration) {
        this.idPlan = idPlan;
        this.namePlan = namePlan;
        this.price = price;
        this.duration = duration;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(int namePlan) {
        this.namePlan = namePlan;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "idPlan=" + idPlan +
                ", namePlan=" + namePlan +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MembershipPlan that = (MembershipPlan) o;
        return idPlan == that.idPlan && namePlan == that.namePlan && Double.compare(price, that.price) == 0 && duration == that.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlan, namePlan, price, duration);
    }
}
