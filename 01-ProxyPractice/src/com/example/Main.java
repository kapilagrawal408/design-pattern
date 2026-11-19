package com.example;

import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {	    
		// 1. Instantiate the real object (which implements both interfaces)
		RealPaymentService realService = new RealPaymentService();
		
		// 2. Instantiate our handler
		TransactionHandler handler = new TransactionHandler(realService);
		
		// 3. Generate the Proxy passing MULTIPLE interfaces
		Object proxyInstance = Proxy.newProxyInstance(
			Main.class.getClassLoader(), 
			new Class<?>[] { PaymentService.class, AuditService.class }, // Both interfaces!
			handler 
		);
	
		// 4. Cast the proxy to PaymentService and use it
		System.out.println("--- CLIENT: Using PaymentService ---");
		PaymentService paymentProxy = (PaymentService) proxyInstance;
		paymentProxy.processPayment(100);
		
		// 5. Cast the EXACT SAME proxy to AuditService and use it
		System.out.println("\n--- CLIENT: Using AuditService ---");
		AuditService auditProxy = (AuditService) proxyInstance;
		auditProxy.logTransaction("Payment of $100 successful");
	}
}