package jungol;

import java.io.*;
import java.util.*;

public class JUNGOL1828 {
	static PriorityQueue<Refrigerator> pq = new PriorityQueue<Refrigerator>();

	static class Refrigerator implements Comparable<Refrigerator> {
		int low;
		int high;

		public Refrigerator(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Refrigerator refri) {
			int diff = this.high - refri.high;
			return diff != 0 ? diff : this.low - refri.low;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] chemicals = br.readLine().split("\\s");
			pq.offer(new Refrigerator(Integer.parseInt(chemicals[0]), Integer.parseInt(chemicals[1])));
		}

		getRefrigerator();
		br.close();
	}

	private static void getRefrigerator() {
		int cnt = 1;
		int big = pq.poll().high;
		int size = pq.size();

		int j = 0;
		for (int i = 0; i < size; i++) {
			if (big >= pq.peek().low) {
				pq.poll();
				j++;
			} else {
				big = pq.poll().high;
				++cnt;
			}
		}

		System.out.println(cnt);
	}

}
