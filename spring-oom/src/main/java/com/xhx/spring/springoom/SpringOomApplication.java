package com.xhx.spring.springoom;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms30M -Xmx30M -XX:+HeapDumpOnOutOfMemoryError
 */
@SpringBootApplication
public class SpringOomApplication implements InitializingBean {

	private List<byte[]> list = new ArrayList<>();
	Thread thread = null;

	public static void main(String[] args) {
		SpringApplication.run(SpringOomApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//oom问题
/*		while (true) {
			//0.5M
			byte[] chars = new byte[1024 * 512];
			list.add(chars);
			Thread.sleep(1500);
		}*/

		//线程100%问题
		thread = new Thread(() -> {
			while (true) {

			}
		});
		thread.start();

	}
}
