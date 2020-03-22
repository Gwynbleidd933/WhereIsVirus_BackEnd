package acn.poc.wiv.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Symptoms implements Serializable {

    private Boolean hasCough;

    private Boolean hasFever;

    private Boolean hasShortnessBreath;

    public Symptoms() {}

    public Symptoms(Boolean hasCough, Boolean hasFever, Boolean hasShortnessBreath) {
        this.hasCough = hasCough;
        this.hasFever = hasFever;
        this.hasShortnessBreath = hasShortnessBreath;
    }

    public Boolean getHasCough() {
        return hasCough;
    }

    public void setHasCough(Boolean hasCough) {
        this.hasCough = hasCough;
    }

    public Boolean getHasFever() {
        return hasFever;
    }

    public void setHasFever(Boolean hasFever) {
        this.hasFever = hasFever;
    }

    public Boolean getHasShortnessBreath() {
        return hasShortnessBreath;
    }

    public void setHasShortnessBreath(Boolean hasShortnessBreath) {
        this.hasShortnessBreath = hasShortnessBreath;
    }

    @Override
    public String toString() {
        return "Symptoms{" +
                "hasCough=" + hasCough +
                ", hasFever=" + hasFever +
                ", hasShortnessBreath=" + hasShortnessBreath +
                '}';
    }
}
