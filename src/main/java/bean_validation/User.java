package bean_validation;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	@NotNull(message = "Name cannot be null")
	private String name;
	
	@AssertTrue
	private boolean working;
	
	@Size(min = 10, max = 100, message = "This must be between 10 and 100 characters")
	private String aboutMe;
	
	@Min(value = 18, message = "Age should not be under 18")
	@Max(value = 150, message = "You're a bit old for this job")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
