package cdi;

@Fancy
public class FancyGreeting implements Greeting{

	@Override
	public String greet(String name) {
		return "Salutations " + name + " and welcome";
	}

}
