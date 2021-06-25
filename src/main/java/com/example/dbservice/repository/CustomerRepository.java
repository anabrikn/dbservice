package com.example.dbservice.repository;

import com.example.dbservice.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    //TODO Исправить запрос. Чтобы запрос работал правильно приходится вводить число на 1 меньше
    //    (Джордж Мартин купил Минеральную воду дважды,
    //    его находят только при minTimes = 0 или 1, при 2 уже не находит)
    @Query("select c from Customer c " +
            "join Purchase p on p.customer = c join Product pr on p.product = pr where pr.name = :name " +
            "group by c.id having count(p.id) > :count")
    List<Customer> findCustomersByPurchaseCount(@Param("name") String name, @Param("count") long count);

    @Query("select c from Customer c join Purchase p on p.customer = c join Product pr on pr = p.product group by c.id " +
            "having sum(pr.expenses) between :minExpenses and :maxExpenses")
    List<Customer> findByExpense(@Param("minExpenses") long minExpenses, @Param("maxExpenses") long maxExpenses);

    //TODO Исправить (не сохраняет порядок). Считает количество сделок.
    @Query("select c, count(p) as cnt from Customer c join Purchase p on p.customer = c group by c.id order by cnt asc")
    List<Object[]> findBadCustomer(Pageable pageable);
}
