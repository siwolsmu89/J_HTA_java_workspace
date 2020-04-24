package oop4;

public class Reporter {

	String[] data;
	DataOutput outputter;
	
	Reporter() {
		DataOutput dop = new DataOutput();
		setOutputter(dop);
	}
	
	void setOutputter(DataOutput dataOutput) {
		this.outputter = dataOutput;
	}
	
	void setData(String[] data) {
		this.data = data;
	}
	
	void reporting() {
		outputter.output(data);
	}
	
	
}
