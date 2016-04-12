package com.novelbio.fans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * ����
 * 
 * @author fans.fan
 *
 */
public class Judgment {

	public Judgment(int groupNumber) {
		this.groupNumber = groupNumber;
		this.barrier = new CyclicBarrier(groupNumber);
		this.countDownLatch = new CountDownLatch(groupNumber);
	}
	
	/** ������� */
	int groupNumber;
	
	/**��֤����ͬʱ����. */
	CyclicBarrier barrier;
	
	/**��֤���鶼���н���ʱ,��ʱ���ؽ��. */
	CountDownLatch countDownLatch;
	
	/** �洢ÿ���������ʹ��ʱ��.  */
	volatile Map<String, Long> mapGroup2Time = new ConcurrentHashMap<>();

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public CyclicBarrier getBarrier() {
		return barrier;
	}

	public void setBarrier(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public Map<String, Long> getMapGroup2Time() {
		return mapGroup2Time;
	}

	public void setMapGroup2Time(Map<String, Long> mapGroup2Time) {
		this.mapGroup2Time = mapGroup2Time;
	}
	
	public void result(){
		for (String group : mapGroup2Time.keySet()) {
			Long time = mapGroup2Time.get(group);
			System.out.println("group = " + group + ",time=" + time);
		}
	}
	
}
