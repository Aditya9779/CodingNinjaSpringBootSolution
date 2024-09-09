package com.cn.cnpayment;

import com.cn.cnpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Author(name = "Aditya Srivastava",date = "10-09-2024")
public class CnPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnPaymentApplication.class, args);

	}
}
