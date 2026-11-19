package com.example;

public class RealPaymentService implements PaymentService, AuditService {  
	@Override
	public void processPayment(int amount) {
		System.out.println("  [REAL OBJECT] Actually processing payment of $" + amount);
	}
	
	@Override
	public void logTransaction(String message) {
		System.out.println("  [REAL OBJECT] Logging to database: " + message);
	}
}