package tera;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileAccessor implements Accessor{

	public void writeLog(String exp) throws Exception{

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/d(E) k:m:s");

		String now = formatter.format(cal.getTime());

		File file = new File("c:/history.txt");

		FileOutputStream out = new FileOutputStream(file,true);
		OutputStreamWriter writer = new OutputStreamWriter(out, "Windows-31J");
		BufferedWriter buff = new BufferedWriter(writer);

		buff.write(now + "→" + exp + "\r\n"); 

		buff.flush();
		buff.close();
	}
}

