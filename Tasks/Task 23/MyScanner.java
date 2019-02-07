import java.io.FileInputStream;
import java.io.InputStream;

class MyScanner {

	private InputStream inputStream;
//	String fileName;
	private int result;
	private int input;
	private boolean valid;

	public MyScanner(String fileName) {
		try {
			this.inputStream = new FileInputStream(fileName);
		} catch (Throwable e) {
			System.out.println("Wrong file name");
		}
//		this.fileName = fileName;
		this.result = 0;
		this.input = 0;
		this.valid = false;
	}

	public int nextInt() {
		try {
			this.input = (inputStream.read());
			while (this.input != -1) {
				if (this.input > 47 && this.input < 58) {
					this.result = this.result * 10;
					this.result += (this.input - 48);
					this.valid = true;
				}
				if ((this.input <= 47 || this.input >= 58) && this.valid) {
					return this.result;
				}
				this.input = (inputStream.read());
			}
		} catch (Throwable e) {
			throw new InvalidInputException();
		}
		if (this.valid) {
			return this.result;
		} else {
			throw new InvalidInputException();
		}
	}
}