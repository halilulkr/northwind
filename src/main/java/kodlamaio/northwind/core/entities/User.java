package kodlamaio.northwind.core.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	@Email
	@NotBlank //veri var içeriği boş space tuşuna basılmış gibi
	@NotNull //hiç veri yok
	private String email;
	
	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;
}
