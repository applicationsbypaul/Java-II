package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Store {
	private String storeCode;
	private String storeName;
	private String storeNumber;
	
	public Store(){
		super();
	}
	
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

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	
}
