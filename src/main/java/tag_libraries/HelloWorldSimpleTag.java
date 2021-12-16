package tag_libraries;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * SimpleTag handler that prints "Hello, world!"
 */
public class HelloWorldSimpleTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
	getJspContext().getOut().write( "Hello, world!" );
    }
}
