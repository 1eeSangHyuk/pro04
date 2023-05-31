package com.myshop.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Range;
 
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	
	private Long id;		//제품아이디
	
    @NotBlank
    private String pname;	//제품명
    
    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;	//가격
    
    @NotNull
    @Max(9999)
    private Integer quantity;	//수량

    public ProductVO(String pname, Integer price, Integer quantity) {
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
    }
}
