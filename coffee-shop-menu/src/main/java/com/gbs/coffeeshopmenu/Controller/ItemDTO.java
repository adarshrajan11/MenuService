package com.gbs.coffeeshopmenu.Controller;

import java.util.List;

import com.gbs.coffeeshopmenu.model.Item;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private List<Item> items;
    private HttpStatus status;
    
    
    
}
