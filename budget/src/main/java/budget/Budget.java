package budget;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Budget {
    private @Id
    @GeneratedValue Long id;
    private String date;
    private String subject;
    private boolean expOrInc;
    private double amount;
    private String description;
    private boolean isLoan;
    private boolean reoccurring;

    Budget() {}

    Budget(String date, String subject, boolean expOrInc, double amount, String description, boolean isLoan, boolean reoccurring){
        this.date = date;
        this.subject = subject;
        this.expOrInc = expOrInc;
        this.amount = amount;
        this.description = description;
        this.isLoan = isLoan;
        this.reoccurring = reoccurring;
    }
/*----- Getter methods -----*/
    public Long getId() {
        return this.id;
    }

    public String getDate(){
        return this.date;
    }

    public String getSubject(){
        return this.subject;
    }

    public boolean getExpOrInc(){
        return this.expOrInc;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean getIsLoan(){
        return this.isLoan;
    }

    public boolean getReoccurring(){
        return this.reoccurring;
    }


/*----- Setter methods -----*/
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public void setExpOrInc(boolean ExpOrInc){
        this.expOrInc = expOrInc;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setIsLoan(boolean isLoan){
        this.isLoan = isLoan;
    }

    public void setReoccurring(boolean reoccurring){
        this.reoccurring = reoccurring;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Budget))
            return false;
        Budget budget = (Budget) o;
        return Objects.equals(this.id, budget.id) && Objects.equals(this.date, budget.date)
                && Objects.equals(this.date, budget.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.date, this.amount, this.description, this.isLoan, this.reoccurring);
    }

    @Override
    public String toString() {
        return "Budget{" + "id=" + this.id + ", Date='" + this.date + '\'' + ", Amount='" + this.amount + '\'' + '}';
    }

}
