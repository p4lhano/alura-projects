package dev.palhano.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;

public class Acess {
		String path;
		LocalDateTime dateTime;
		Duration duration;
		@Override
		public String toString() {
			return "Acess [dateTime=" + dateTime + ", duration=" + duration + ", path=" + path + "]";
		}
		public String getPath() {
			return path;
		}
		public LocalDateTime getDateTime() {
			return dateTime;
		}
		public Duration getDuration() {
			return duration;
		}
}
