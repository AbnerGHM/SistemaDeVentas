package com.java.abner.abarrotes.hernandez.app.processors;

import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.java.abner.abarrotes.hernandez.app.domain.models.Producto;

public class ProductItemProcessor implements ItemProcessor<Producto, Producto> {
	private static final Logger log = LoggerFactory.getLogger(ProductItemProcessor.class);
	@Override
	public Producto process(Producto item) throws Exception {
		
		
		return null;
	}

}
