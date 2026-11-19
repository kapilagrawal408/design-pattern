package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
	private final Object target; 

	public TransactionHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    
		// Find out which interface this method belongs to
		String interfaceName = method.getDeclaringClass().getSimpleName();
		
		System.out.println("\n[PROXY] Intercepted call from interface: " + interfaceName);
		System.out.println("[PROXY] Method called: " + method.getName());
		
		// Dispatch the request to the real object
		Object result = method.invoke(target, args);
		
		System.out.println("[PROXY] Finished executing " + method.getName());
		
		return result;
	}
}