package taxi.project.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "bookingform")
public class BookingForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name Can't be empty")
	@NotBlank(message = "Name can't be blank")
	@Size(min = 5, max = 30, message = "Invalid name length")
	@Pattern(regexp = "^[A-Za-z]+$", message = "name only contain alphabet")
	@Column(length = 30)
	private String name;
	
	@NotEmpty(message = "source Can't be empty")
	@NotBlank(message = "source can't be blank")
	@Size(min = 5, max = 100, message = "Invalid from length")
	@Column(length = 100)
	private String source;
	
	@NotEmpty(message = "Email Can't be empty")
	@NotBlank(message = "email can't be blank")
	@Size(min = 5, max = 50, message = "Invalid name length")
	@Column(length = 50)
	private String email;
	
	@NotEmpty(message = "destination Can't be empty")
	@NotBlank(message = "destination can't be blank")
	@Size(min = 2, max = 105, message = "Invalid destination length")
	@Column(length = 105)
	private String destination;	
	
	@NotNull(message = "time Can't be empty")
	private LocalTime time;
	
	@NotNull(message = "date Can't be empty")
	private LocalDate date;
	
	@NotEmpty(message = "Comfort Can't be empty")
	@Size(min = 2, max = 20, message = "Invalid comfort length")
	@Column(length = 20)
	private String comfort;
	
	@Min(value = 1, message = "adult can be at most 1")
	@Max(value = 4, message = "adult can be at most 4")
	private int adult;
	
	@Max(value = 3, message = "children can be at most 3")
	private int children;
	
	@NotEmpty(message = "Message Can't be empty")
	@NotBlank(message = "Message can't be blank")
	@Size(min = 5, max = 2000, message = "Invalid Message length")
	@Column(length = 2000)
	private String message;

}
