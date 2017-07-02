package org.aries;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSerialNoUtil {
	private Random random = new Random();
	private long time = System.currentTimeMillis();
	private long index = 0;

	private final Set<String> ids = new HashSet<>();

	private String makeSeries(int length, boolean autoIncrement) {
		if (!autoIncrement) {
			StringBuilder sb = new StringBuilder();
			while (sb.length() < length) {
				int cLen = Math.min(3, length - sb.length());
				String c = "";
				while (c.length() < cLen) {
					c += String.valueOf(this.random.nextInt((int) Math.pow(10, cLen - c.length())));
				}
				sb.append(c);
			}
			return sb.toString();
		} else {
			if (length == 0) {
				return "";
			} else {
				String s = String.valueOf(index++);
				if (s.length() > length || index >= Long.MAX_VALUE) {
					index = 0;
					s = String.valueOf(index);
				}
				byte[] r = new byte[length];
				Arrays.fill(r, (byte) '0');
				byte[] c = s.getBytes();
				System.arraycopy(c, 0, r, r.length - c.length, c.length);
				return new String(r);
			}
		}
	}

	public synchronized String makeKey(int length, boolean autoIncrement) {
		return this.makeKey(null, DateFormatUtil.dateTime2, length, autoIncrement);
	}

	public synchronized String makeKey(SimpleDateFormat sdf, int length, boolean autoIncrement) {
		return this.makeKey(null, sdf, length, autoIncrement);
	}

	public synchronized String makeKey(String prefix, int length, boolean autoIncrement) {
		return this.makeKey(prefix, DateFormatUtil.dateTime2, length, autoIncrement);
	}

	public synchronized String makeKey(String prefix, SimpleDateFormat sdf, int length, boolean autoIncrement) {
		while (true) {
			if (System.currentTimeMillis() - this.time > 1000) {
				this.ids.clear();
				this.time = System.currentTimeMillis();
			}
			String series = this.makeSeries(length, autoIncrement);
			if (!this.ids.contains(series)) {
				this.ids.add(series);
				return StringUtil.trim(prefix) + sdf.format(this.time) + series;
			}
		}
	}
}
