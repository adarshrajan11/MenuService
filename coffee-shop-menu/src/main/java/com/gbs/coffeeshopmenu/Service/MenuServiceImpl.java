package com.gbs.coffeeshopmenu.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.gbs.coffeeshopmenu.Repository.MenuRepository;
import com.gbs.coffeeshopmenu.model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Optional<Menu> GetMenuByMonth(LocalDate menuDate) {
       
        return null;
    }

   
    
    @Override
    public Menu create(Menu menu) {
       menuRepository.save(menu);
        return null;
    }

    // @Override
    // public void delete(Integer id) {
    //     menuRepository.deleteById(id);
        
    // }

    @Override
    public void deleteByDate(LocalDate menuDate) {
      
        menuRepository.deleteBymenuDate(menuDate);
    }

    @Override
    public List<Menu> findAll() {
       
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> findMenuById(Integer id) {
        
        return menuRepository.findById(id);
    }

    @Override
    public Menu save(Menu menu) {
        
        return menuRepository.save(menu);
    }


    @Override
    public Menu GetMenuBymenuDate(LocalDate menuDate, LocalDate menuDate2) {
       return menuRepository.findBymenuDateBetween(menuDate,menuDate2);
        
    }
    
    
}
