package utility;


public class Trace {
	public long time;
	public double [] values = null;
	public int dim;
	public String type;
	
    public static String ACCELEROMETER = "accelerometer";
    public static String GYROSCOPE = "gyroscope";
    public static String MAGNETOMETER = "magnetometer";

    public static String ROTATION_MATRIX = "rotation_matrix";
    public static String GPS = "gps";
	

	public Trace() {
		time = 0;
		dim = 3;
		values = new double [dim];
	}
	
	public Trace(int d) {
		time = 0;
		dim = d;
		values = new double [dim];
	}
	
	public void setValues(double x, double y, double z) {
		values[0] = x;
		values[1] = y;
		values[2] = z;
		dim = 3;
	}
	
	
	public void copyTrace(Trace trace) {
		this.time = trace.time;
		this.dim = trace.dim;
		this.values = new double[dim];
		for(int i = 0; i < dim; ++i) {
			this.values[i] = trace.values[i];
		}
	}
	
	public void getTrace(String line) {
		
		String[] res = line.split(Constants.kInputSeperator);
		try {
			time = Long.parseLong(res[0]);
			//time = (long) (Double.parseDouble(res[0]) * 1000.0);
		} catch (NumberFormatException e) {
			//handle error time format
			time = 0;
		}
		//Log.log(dim, line);
		for(int i = 0; i < dim; ++i) {
			try {
				values[i] = Double.parseDouble(res[i + 1]);	
			} catch (NumberFormatException e) {
				values[i] = 0.0;
			}
		}
		
		//System.out.println(time + Constants.kSeperator + values[0]);
	}
	
	

}