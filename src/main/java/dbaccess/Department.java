package dbaccess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "getDepartmentByNr", query = "SELECT d FROM Department d where department_nr = :deptNr")
})
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DEPARTMENT_NR")
	private int departmentNr;
	
	@NotNull
	private String name;
	
	@NotNull
	private String location;
	
	public Department() {
		
	}
	
	@Override
	public String toString() {
		return "Department [departmentNr=" + departmentNr + ", name=" + name + ", location=" + location + "]";
	}



	public int getDepartmentNr() {
		return departmentNr;
	}

	public void setDepartmentNr(int departmentNr) {
		this.departmentNr = departmentNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
