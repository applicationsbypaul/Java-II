package model;

public class TempConverter {
	
	private double degree;
	private double old_Degree;
	private String conversion;
	
	
	public TempConverter() {
		super();
	}
	
	public TempConverter(double degree, String conversion) {
		super();
		this.degree = degree;
		this.old_Degree = degree;
		this.conversion = conversion;
		convertTemp(degree,conversion);
	}
	public TempConverter(double degree) {
		super();
		this.degree = degree;
		this.old_Degree = degree;
		convertTemp(degree);
	}

	public double getOld_Degree() {
		return old_Degree;
	}

	public void setOld_Degree(double old_degree) {
		this.old_Degree = old_degree;
	}
	/**
	 * this is to do the opposite conversion
	 * @param degree
	 */
	public void convertTemp(double degree) {
		if(this.conversion.contentEquals("Celsius")){
			setDegree(degree * 1.8+32);
		}else{
			setDegree(((degree - 32)/1.8));
		}
	}

	/**
	 * converts the degrees from C to F
	 * @param degree
	 * @param conversion
	 */
	public void convertTemp(double degree, String conversion) {
		if(conversion.contentEquals("Celsius")){
			setDegree(((degree - 32)/1.8));
		}else{
			setDegree(degree * 1.8+32);
		}
	}		
	
	@Override
	public String toString() {
		return "TempConverter [degrees = " + degree + ", conversion: " + conversion + "original degrree: "
				+ old_Degree ;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double d) {
		this.degree = Math.round(d*100)/100;
	}

	public String getConversion() {
		return conversion;
	}

	public void setConversion(String conversion) {
		this.conversion = conversion;
	}

}
