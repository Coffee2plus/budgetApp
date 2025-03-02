package budget;

//import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@RestController
public class BudgetController {

    private final BudgetRepository repository;

    BudgetController(BudgetRepository repository) {
        this.repository = repository;
    }

//    Aggregate root
//    tag::get-aggregate-root[]
    @GetMapping("/budgets")
    CollectionModel<EntityModel<Budget>> all() {
        List<EntityModel<Budget>> budgets = repository.findAll().stream()
                .map(budget -> EntityModel.of(budget,
                        linkTo(methodOn(BudgetController.class).one(budget.getId())).withSelfRel(),
                        linkTo(methodOn(BudgetController.class).all()).withRel("budgets")))
                                .collect(Collectors.toList());
        return CollectionModel.of(budgets, linkTo(methodOn(BudgetController.class).all()).withSelfRel());
    }
//    end::get-aggregate-root[]

    @PostMapping("/budgets")
    Budget newBudget(@RequestBody Budget newBudget) {
        return repository.save(newBudget);
    }

//    Single item

    @GetMapping("/budgets/{id}")
    EntityModel<Budget> one(@PathVariable Long id) {

        Budget budget = repository.findById(id)
                .orElseThrow(() -> new BudgetNotFoundException(id));

        return EntityModel.of(budget,
                linkTo(methodOn(BudgetController.class).one(id)).withSelfRel(),
                linkTo(methodOn(BudgetController.class).all()).withRel("budgets"));
    }

    @PutMapping("/budgets/{id}")
    Budget replaceBudget(@RequestBody Budget newBudget, @PathVariable Long id){

        return repository.findById(id)
                .map(budget -> {
                    budget.setDate(newBudget.getDate());
                    budget.setSubject(newBudget.getSubject());
                    budget.setExpOrInc(newBudget.getExpOrInc());
                    budget.setAmount(newBudget.getAmount());
                    budget.setDescription(newBudget.getDescription());
                    budget.setIsLoan(newBudget.getIsLoan());
                    budget.setReoccurring(newBudget.getReoccurring());
                    return repository.save(budget);
                })
                .orElseGet(() -> {
                    return repository.save(newBudget);
                });
    }

    @DeleteMapping("/budgets/{id}")
    void deleteBudget(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
