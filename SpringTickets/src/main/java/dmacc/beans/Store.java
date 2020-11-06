package dmacc.beans;

import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Store {
	private String storeCode;
	private String storeName;
	private String storeNumber;
	
	
	public Store(String storeCode, String storeName, String storeNumber) {
		super();
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.storeNumber = storeNumber;
	}

	@Override
	public String toString() {
		return "Store [storeCode=" + storeCode + ", storeName=" + storeName + ", storeNumber=" + storeNumber + "]";
	}

}
