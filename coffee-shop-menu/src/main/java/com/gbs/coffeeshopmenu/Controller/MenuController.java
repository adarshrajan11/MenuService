package com.gbs.coffeeshopmenu.Controller;
import java.time.LocalDate;
import java.util.List;       
import com.gbs.coffeeshopmenu.Service.MenuService;
import com.gbs.coffeeshopmenu.model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class MenuController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MenuService menuService;
    // private MenuRepository menuRepository;
    @PostMapping(value = "/menus/lists")
    public ResponseEntity<Menu> createMenu(@RequestBody List<Integer> items){
        ItemDTO itemDTO=restTemplate.postForObject("http://localhost:9000/api/items/lists", 
                                    items,
                                    ItemDTO.class);
        Menu entity=new Menu();
        entity.setItems(itemDTO.getItems());
        entity.setUpdatedOn(LocalDate.now());
        Menu menu=menuService.save(entity);
        return ResponseEntity.status( HttpStatus.CREATED).body(menu);
    }
    // @PostMapping("/menus/lists")
    // public ResponseEntity<Menu> createMenu


    @GetMapping(value = "/menus")
    public ResponseEntity<List<Menu>>getMenu()
    {
        return ResponseEntity.ok().body(menuService.findAll());
    }
    @GetMapping(value="/menus/{id}")
    public Menu getMenuById(@PathVariable Integer id){
        return menuService.findMenuById(id).orElseThrow();
    }
    @PostMapping(value="/menus")
    public ResponseEntity<Menu> postBody(@RequestBody Menu menu){
        return ResponseEntity.ok().body(menuService.create(menu));
    }
    @PutMapping(value="/menus/{id}")
    public ResponseEntity<Menu> updaEntity(@PathVariable String id, @RequestBody Menu menu) {
        try {
            return new ResponseEntity<Menu>(menuService.save(menu),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
    }
    //     @DeleteMapping("/menus/{id}")
    //    public void deletemenu(@PathVariable Integer id ) {
    //        menuService.delete(id);
           
    //    }
       @DeleteMapping("/menus/{menuDate}")
       public void deletebyMenuDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate menuDate){
           menuService.deleteByDate(menuDate);
       }

       @GetMapping("/menus/{menuDate}/{menuDate2}")
       public Menu getByrangeMenu(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate  menuDate,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate menuDate2){
        return menuService.GetMenuBymenuDate(menuDate, menuDate2);
    }


            
    }
    
    



