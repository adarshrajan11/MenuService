package com.gbs.coffeeshopmenu.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Menu {
    @Id
    @GeneratedValue
    private Integer id;

    
    @Column(name="Menu_date")
    private LocalDate menuDate;

    @OneToMany(mappedBy = "menu", 
    cascade =  CascadeType.ALL, 
    fetch = FetchType.EAGER)
private List<Item> items;
    
   
    @Column(name="updated_on")
    private LocalDate UpdatedOn;
    
}
