package com.gbs.coffeeshopmenu.Repository;
import java.time.LocalDate;


import com.gbs.coffeeshopmenu.model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {

    void deleteBymenuDate(LocalDate menuDate);
     Menu findBymenuDateBetween(LocalDate menuDate, LocalDate menuDate2);
    
}
