package terry.codex;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-11-4 下午4:23:23
 * @文件描述: String +、StringBuilder、StringBuffer性能测试
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Measurement(iterations = 20, time = 5, timeUnit = TimeUnit.SECONDS)
//@Threads(8)
@Timeout(time=10,timeUnit=TimeUnit.MINUTES)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringAddTest {

	@Benchmark
	public void StringAdd() {
		String str = "";
		for (int i = 0; i < 100; i++) {
			str += i;
		}
	}

	@Benchmark
	public void StringBufferAdd() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			str.append(i);
		}
	}

	@Benchmark
	public void StringBuilderAdd() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			str.append(i);
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(StringAddTest.class.getSimpleName())
				.forks(1).build();

		new Runner(opt).run();

	}

}
