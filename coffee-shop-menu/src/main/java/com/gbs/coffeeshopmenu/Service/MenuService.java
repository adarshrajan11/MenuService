package com.gbs.coffeeshopmenu.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.gbs.coffeeshopmenu.model.Menu;



public interface MenuService {
    Menu create(Menu menu);


    List<Menu> findAll();

    Menu save(Menu menu);

    Optional<Menu>findMenuById(Integer id);

    Optional<Menu>GetMenuByMonth(LocalDate menuDate);

    Menu GetMenuBymenuDate(LocalDate menuDate,LocalDate menuDate2);

    public void deleteByDate(LocalDate menuDate) ;



    // void delete(Integer id);
    
}
