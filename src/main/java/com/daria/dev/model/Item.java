package com.daria.dev.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
public class Item implements IEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter @Setter
    private Long id;

    @NotEmpty
    @Getter @Setter
    private String title;

    @Getter @Setter
    @NotNull
    private double price;

    @OneToMany @Getter @Setter
    @JsonBackReference
    private Collection<ItemUnit> itemUnits;

    @Override
    public Long getId() {
        return id;
    }

    public Item(@NotEmpty String title, @NotNull double price) {
        this.title = title;
        this.price = price;
    }
}
