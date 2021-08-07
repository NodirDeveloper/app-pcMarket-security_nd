package uz.pdp.apppcmarketsecu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private double incomePrice;

    private double salePrice;

    private String description;

    @ManyToOne(optional = false)
    private Brand brand;

    @ManyToOne(optional = false)
    private Category category;

    @OneToOne(optional = false)
    private Attachment attachment;

    @ManyToOne(optional = false)
    private Measurement measurement;



}
