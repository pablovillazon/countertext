package be.jkin.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@SpringBootApplication
public class CounterApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(CounterApplication.class);
	private Object Function;

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(CounterApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String[] args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		if(args.length == 0) {
			LOG.error("Ingrese la ruta del archivo");
			return;
		}

		String filePath = args[0] != null? args[0]: "c:\\Temp\\words.txt";

		//a cool way to read file
		LOG.info("Reading in a coolest way");

		Path path = Paths.get(filePath);
		Map<String, Integer> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
				.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
				.filter(word -> word.length() > 0)
				.map(word -> new AbstractMap.SimpleEntry<>(word, 1))
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));

		wordCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(System.out::println);

		LOG.info("---End Reading in a coolest way---");
	}

}
