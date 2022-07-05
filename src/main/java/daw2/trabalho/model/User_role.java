package daw2.trabalho.model;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class User_role implements Serializable {

	@Id
	private Long user_id;
	private Long role_id;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(role_id, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User_role other = (User_role) obj;
		return Objects.equals(role_id, other.role_id) && Objects.equals(user_id, other.user_id);
	}
	@Override
	public String toString() {
		return "User_role [user_id=" + user_id + ", role_id=" + role_id + "]";
	}
	
	
	
}