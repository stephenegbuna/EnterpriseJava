package cdi;

public class SimpleGreeting implements Greeting{

	@Override
	public String greet(String name) {
		return "Hello " + name;
	}

}
