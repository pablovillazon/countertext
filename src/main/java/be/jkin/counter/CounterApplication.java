package be.jkin.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class CounterApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(CounterApplication.class);
	private Object Function;

	public static void main(String[] args) {

		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(CounterApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	interface Function<T>
	{
		void apply(T t);
	}
	@Override
	public void run(String[] args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		String filePath = "c:\\Temp\\words.txt";
/*
		if(args.length == 0) {
			System.out.println("Ingrese la ruta del archivo");
			return;
		}

		StringBuilder sb = new StringBuilder();

		try(BufferedReader br = Files.newBufferedReader(Paths.get(args[0])))
		{
			String line;
			while((line=br.readLine()) != null){
				sb.append(line).append("\n");
			}
		}catch(IOException ex){
			LOG.error(ex.getMessage());
			System.err.format("IOException: %s%n", ex);
		}
*/
		//System.out.println(sb);
		/*
		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}*/

		//another cool way to read file
		LOG.info("Reading in a coolest way");
		Files.lines(new File(filePath).toPath())
				.map(s -> s.trim())
				.filter(s-> !s.isEmpty())
				.forEach(System.out::println);
		

		LOG.info("---End Reading in a coolest way---");

	}
}
