package com.ironhack.midtermAndreaRod;

import com.ironhack.midtermAndreaRod.model.Account;
import com.ironhack.midtermAndreaRod.model.Money;
import com.ironhack.midtermAndreaRod.model.Savings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootApplication
public class MidtermAndreaRodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidtermAndreaRodApplication.class, args);
	}


}
