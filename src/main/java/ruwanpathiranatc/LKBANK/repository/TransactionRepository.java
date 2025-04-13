package ruwanpathiranatc.LKBANK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruwanpathiranatc.LKBANK.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, String> {
}
