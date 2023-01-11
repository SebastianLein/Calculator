package Calculator;

public enum Comma {
COMMA(".");

    private String comma;

	Comma(String comma) {
        this.comma = comma;
    }

	public String getComma() {
		return comma;
	}
}
