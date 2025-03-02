package budget;

public class BudgetNotFoundException extends RuntimeException{
    BudgetNotFoundException(Long id) {
        super("Could not find budget " + id);
    }
}
