package com.gbs.coffeeshopmenu.Controller;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private LocalDate menuDate;
    private List<Integer>Items;
    
    
}
