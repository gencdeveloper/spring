package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Data
public class Item extends BaseEntity{

    private String name;
    private String code;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @ManyToMany(mappedBy = "itemList")
    private List<Cart> cart;
}
