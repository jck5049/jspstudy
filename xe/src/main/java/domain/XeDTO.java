package domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XeDTO {
	private int xeNo;
	private String xeContent;
	private Timestamp xeCreatedAt;
	
}
