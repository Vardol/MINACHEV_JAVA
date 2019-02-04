public abstract class Mechanized extends Transport {
	protected String enginenumber;
	public static final String engine = "Engine roars. ";

	protected String generateEngineNumber() {
		String result = (super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter() + "" + super.generateDigit() + "" + super.generateLetter());
		return result;
	}

	public String getEngineNumber() {
		return this.enginenumber;
	}
}