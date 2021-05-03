package deliveredEmail.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DeliveredEmailDto {
	private Long courseNo;
	private String address;
	private String title;
	private String message;
	private String filename;
	private String filepath;
	private String category;
}
