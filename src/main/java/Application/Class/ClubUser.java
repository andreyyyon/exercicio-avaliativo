package Application.Class;

import java.util.Objects;

public class ClubUser {
    private String name;
    private Integer number = 0;
    private String sex;
    private Float heigth;
    private Float wage;
    private Integer dependents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubUser clubUser = (ClubUser) o;
        return wage.equals(clubUser.wage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wage);
    }

    public ClubUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Float getHeigth() {
        return heigth;
    }

    public void setHeigth(Float heigth) {
        this.heigth = heigth;
    }

    public Float getWage() {
        return wage;
    }

    public void setWage(Float wage) {
        this.wage = wage;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependents) {
        this.dependents = dependents;
    }
}
