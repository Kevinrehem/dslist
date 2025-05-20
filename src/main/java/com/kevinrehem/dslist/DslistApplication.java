package com.kevinrehem.dslist;

import com.kevinrehem.dslist.entities.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
public class DslistApplication {

	public static void main(String[] args) {
		for (Field field: Game.class.getDeclaredFields()){
			System.out.println(field.getName());
		}
		SpringApplication.run(DslistApplication.class, args);
	}

}
