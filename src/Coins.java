import java.util.LinkedHashMap;

public class Coins {
    private LinkedHashMap<Integer, Integer> NominationsAmount;
    public Coins(LinkedHashMap<Integer, Integer> NominationAmount){
        this.NominationsAmount = NominationAmount;
    }

    public LinkedHashMap<Integer, Integer> getNominationsAmount() {
        return NominationsAmount;
    }

    public void setNominationsAmount(LinkedHashMap<Integer, Integer> nominationsAmount) {
        NominationsAmount = nominationsAmount;
    }
}
