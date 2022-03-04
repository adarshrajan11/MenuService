package com.gbs.coffeeshopmenu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name ="item_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @Column(name = "price")
    private Double price;
    @Column(name = "item_description")
    private String description;

    @Column(name = "item_image")
    @Lob
    private String imageUrl;

    @Column(name = "")
    private LocalDate updatedDate;


    
}
