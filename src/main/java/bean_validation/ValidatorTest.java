package bean_validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebServlet("/validator")
public class ValidatorTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator valid = factory.getValidator();
		
		User user = new User();
		user.setName("Ned");
		user.setWorking(true);
		user.setAboutMe("Me me me me");
		user.setAge(197);
		
		Set<ConstraintViolation<User>> violations = valid.validate(user);
		PrintWriter out = response.getWriter();
		
		if (violations.isEmpty()) {
			out.println("Passed");
		} else {
			out.println("Failed");
			for (ConstraintViolation<User> violation : violations) {
				out.println(violation.getMessage());
			}
		}
				
	}

}
