package com.daria.dev.model;

import com.daria.dev.model.size.GeneralSize;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
public class ItemUnit implements IEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @NotNull
    @JsonManagedReference
    private Item item;

    @Getter @Setter @NotEmpty
    private String color;

    @Getter @Setter @NotNull
    private GeneralSize size;

    @Getter @Setter
    private int quantity;

    @Override
    public Long getId() {
        return id;
    }

    public ItemUnit(@NotNull Item item, @NotEmpty String color, @NotEmpty GeneralSize size, @NotEmpty int quantity) {
        this.item = item;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }
}

