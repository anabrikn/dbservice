package com.example.dbservice.repository;

import com.example.dbservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

//TODO статистика по Customer. Дан период, включая from и to, исключая выходные.
// Результат - число дней, общая стоимость покупок, упорядочить по убыванию стоимости
@Repository
public interface StatRepository extends JpaRepository<Customer, Long>  {
    /*
    @Query(value = "", nativeQuery = true)
    List<Object[]> customerStat(@Param("from") LocalDate from, @Param("to") LocalDate to);
     */
}
