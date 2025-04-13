package ruwanpathiranatc.LKBANK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruwanpathiranatc.LKBANK.entity.Transactions;

public interface CardRepository extends JpaRepository<Transactions, String> {
}
