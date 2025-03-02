package budget;

import org.springframework.data.jpa.repository.JpaRepository;


    interface BudgetRepository extends JpaRepository<Budget, Long>{

    }

